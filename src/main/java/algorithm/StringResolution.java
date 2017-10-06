package algorithm;

import java.util.Stack;

/**
 * 该类创建于 2009-7-20 下午04:29:30
 * 字符串代数运算器
 * @version 1.0.0
 * @author 侯磊
 */
public class StringResolution {
	public static final double DERROR = 0.0000001d;// 浮点数的精度。
	public static final double BIGNUMBER = 0.0d;

	static class Operand {
		public int startIndex = 0; // start index which in formula
		public boolean isConst = false; // TRUE when it is digital, FALSE
										// otherwise
		public String name = ""; // digital string or variant name

		public Operand() {
		}

		public Operand(int startIndex, boolean isConst, String name) {
			this.startIndex = startIndex;
			this.isConst = isConst;
			this.name = name;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (this == obj)
				return true;
			if (obj instanceof Operand) {
				Operand od = (Operand) obj;
				return (isConst == od.isConst) && (name.equals(od.name));
			}
			return false;
		}
	}

	static class Operator {
		public int level; // 优先级
		// or - 1
		// and - 2
		// == <> - 3
		// > >= < <= 4
		// +,- 5
		// *,/,% 6
		// ^ 7
		// function 8
		// not 9
		// -,+ 10
		public byte op; // 具体的操作
		public byte type; // 0--单目运算, 1--双目运算
		public int startIndex; // start index which in formula

		public static final int LEVELS = 55;//

		public static final int UNARY = 0;// 0--单目运算
		public static final int BINARY = 1;// 1--双目运算

		public static final byte OP_OR = 1;
		public static final byte OP_AND = 2;
		public static final byte OP_EQUAL = 3;
		public static final byte OP_NOTEQUAL = 4;
		public static final byte OP_GT = 5;
		public static final byte OP_GE = 6;
		public static final byte OP_LT = 7;
		public static final byte OP_LE = 8;
		public static final byte OP_ADD = 9;
		public static final byte OP_SUB = 10;
		public static final byte OP_MUL = 11;
		public static final byte OP_DIV = 12;
		public static final byte OP_MOD = 13;
		public static final byte OP_MMUL = 14;
		public static final byte OP_FUNC = 15;
		public static final byte OP_NOT = 16;
		public static final byte OP_NEG = 17;
		public static final byte OP_POS = 18;
		public static final byte OP_ASSIGN = 19;
	}

	static boolean IsDigit(char ch) {
		return Character.isDigit(ch);
	}

	static boolean IsZero(double d) {
		return d < DERROR || d > -DERROR;
	}

	static int BooleanToInt(boolean b) {
		return b ? 1 : 0;
	}

	private int oprandNum = 0;// operand number
	private int oprandANum = 0;// variant number
	private int operatorNum = 0;// operator number

	private char[] dstname = null; // 赋值变量名
	private String formula = null; // formula string
	private Operator operator[] = null;// pointer points to operators set
	private Operand oprand[] = null;// pointer points to operands set
	private Operand oprandA[] = null;// pointer points to variants set

	public StringResolution(String formula) {
		if (formula != null) {
			this.formula = formula.toUpperCase();
			initialize();
		}
	}

	private void initialize() {
		Stack<Operator> Op = getOperatorStack();
		Stack<Operand> Od = getOperandStack();
		if (Od == null || Op == null) {
			return;
		}
		oprandNum = Od.size();
		operatorNum = Op.size();

		if (operatorNum != 0)
			operator = new Operator[operatorNum];
		if (oprandNum != 0)
			oprand = new Operand[oprandNum];

		int i;
		for (i = 0; i < operatorNum; i++) {
			Operator op = (Operator) Op.peek();
			operator[operatorNum - i - 1] = op;
			Op.pop();
			op = null;
		}
		for (i = 0; i < oprandNum; i++) {
			Operand od = (Operand) Od.peek();
			oprand[oprandNum - i - 1] = od;
			Od.pop();
			od = null;
		}
		oprandA = new Operand[oprandNum];
		boolean IsIn = false;
		for (i = 0; i < oprandNum; i++) {
			for (int j = 0; j < oprandANum; j++) {
				if (oprand[i].equals(oprandA[j])) {
					IsIn = true;
					break;
				}
			}
			if (!IsIn && !oprand[i].isConst) {
				oprandA[oprandANum] = oprand[i];
				oprandANum++;
			}
			IsIn = false;
		}
		// System.out.println();;
	}

	private Stack<Operand> getOperandStack() {   
        Stack<Operand> oprStack = new Stack<Operand>();   
        int i = 0;   
        int num = formula.length();   
        while (i < num) {   
            if (formula.charAt(i) == '#' || formula.charAt(i) == '@'  
                    || formula.charAt(i) == ' ' || formula.charAt(i) == '\t')   
                i++;   
            else {   
                Operand oprand = new Operand();   
                if (IsDigit(formula.charAt(i))) oprand.isConst = true;   
                oprand.startIndex = i;   
                boolean HasPoint = false;   
                while (i < num && formula.charAt(i) != '#' && formula.charAt(i) != '@') {   
                    if (formula.charAt(i) == '.') {   
                        if (HasPoint) {   
                            oprand = null;   
                            return null;   
                        } else  
                            HasPoint = true;   
                    }   
                    if (oprand.isConst && !IsDigit(formula.charAt(i))   
                            && (formula.charAt(i) != '.')) {   
                        oprand = null;   
                        return null;   
                    }   
                    oprand.name += formula.charAt(i);   
                    i++;   
                }   
                oprStack.push(oprand);   
            }   
        }   
        return oprStack;   
    }

	private Stack<Operator> getOperatorStack() {
		Stack<Operator> operStack = new Stack<Operator>();
		char buff[] = new char[formula.length()];
		formula.getChars(0, buff.length, buff, 0);
		Operator op = null;
		int i = 0;
		int level = 0;
		while (i < buff.length) {
			switch (buff[i]) {
			case '(':
				level += Operator.LEVELS;
				buff[i] = '#';
				i++;
				break;
			case ')':
				level -= Operator.LEVELS;
				buff[i] = '@';
				i++;
				break;
			case '+':
			case '-':
				op = new Operator();
				op.level = level + 5;
				op.startIndex = i;
				if (i == 0 || buff[i - 1] == '#') {
					op.type = Operator.UNARY;
					op.level += 5;
					if (buff[i] == '-')
						op.op = Operator.OP_NEG;
					else
						op.op = Operator.OP_POS;
				} else {
					op.type = Operator.BINARY;
					if (buff[i] == '-')
						op.op = Operator.OP_SUB;
					else
						op.op = Operator.OP_ADD;
				}
				operStack.push(op);
				buff[i] = '@';
				i++;
				break;
			case '*':
			case '/':
			case '%':
				op = new Operator();
				op.level = level + 6;
				if (buff[i] == '*')
					op.op = Operator.OP_MUL;
				else if (buff[i] == '/')
					op.op = Operator.OP_DIV;
				else
					op.op = Operator.OP_MOD;
				op.startIndex = i;
				op.type = Operator.BINARY;
				operStack.push(op);
				buff[i] = '@';
				i++;
				break;
			case '^':
				op = new Operator();
				op.level = level + 7;
				op.op = Operator.OP_MMUL;
				op.startIndex = i;
				op.type = Operator.BINARY;
				operStack.push(op);
				buff[i] = '@';
				i++;
				break;
			case 'a':
				if (i + 2 < buff.length && buff[i + 1] == 'n' && buff[i + 2] == 'd') {
					op = new Operator();
					op.level = level + 2;
					op.op = Operator.OP_AND;
					op.startIndex = i;
					op.type = Operator.BINARY;
					operStack.push(op);
					buff[i] = '@';
					buff[i + 1] = '@';
					buff[i + 2] = '@';
					i += 3;
				}
				break;
			case 'o':
				if (i + 1 < buff.length && buff[i + 1] == 'r') {
					op = new Operator();
					op.level = level + 1;
					op.op = Operator.OP_OR;
					op.startIndex = i;
					op.type = Operator.BINARY;
					operStack.push(op);
					buff[i] = '@';
					buff[i + 1] = '@';
					i += 2;
				}
				break;
			case 'n':
				if (i + 2 < buff.length && buff[i + 1] == 'o' && buff[i + 2] == 't') {
					op = new Operator();
					op.level = level + 9;
					op.op = Operator.OP_NOT;
					op.startIndex = i;
					op.type = Operator.UNARY;
					operStack.push(op);
					buff[i] = '@';
					buff[i + 1] = '@';
					buff[i + 2] = '@';
					i += 3;
				}
				break;
			case '>':
				op = new Operator();
				op.level = level + 4;
				op.startIndex = i;
				op.type = Operator.BINARY;
				buff[i] = '@';
				operStack.push(op);
				if (i + 1 < buff.length && buff[i + 1] == '=') {
					op.op = Operator.OP_GE;
					buff[i + 1] = '@';
					i += 2;
				} else {
					op.op = Operator.OP_GT;
					i += 1;
				}
				break;
			case '<':
				op = new Operator();
				op.startIndex = i;
				op.type = Operator.BINARY;
				buff[i] = '@';
				operStack.push(op);
				if (i + 1 < buff.length && buff[i + 1] == '=') {
					op.level = level + 4;
					op.op = Operator.OP_LE;
					buff[i + 1] = '@';
					i += 2;
					break;
				}
				if (i + 1 < buff.length && buff[i + 1] == '>') {
					op.level = level + 3;
					op.op = Operator.OP_NOTEQUAL;
					buff[i + 1] = '@';
					i += 2;
					break;
				}
				op.level = level + 4;
				op.op = Operator.OP_LT;
				i += 1;
				break;
			case '=':
				if (i + 1 < buff.length && buff[i + 1] == '=') {
					op = new Operator();
					op.level = level + 3;
					op.op = Operator.OP_EQUAL;
					op.startIndex = i;
					op.type = Operator.BINARY;
					operStack.push(op);
					buff[i] = '@';
					buff[i + 1] = '@';
					i += 2;
					break;
				}
				int lastpos = 0;
				op = operStack.peek(); // new Operator();
				if (op != null)
					lastpos = op.startIndex;

				int ii = i - lastpos + 1;
				dstname = new char[ii];
				System.arraycopy(buff, lastpos, dstname, 0, ii - 1);
				ii = buff.length;
				System.arraycopy(buff, i + 1, buff, lastpos, ii - i - 1);
				buff[lastpos + ii - i - 1] = 0;
				char temp[] = new char[lastpos + ii - i];
				System.arraycopy(buff, 0, temp, 0, temp.length);
				buff = temp;
				i = lastpos;
				break;
			default:
				i++;
			}
		}
		formula = new String(buff);
		return operStack;
	}

	public double computer(double variantValue[], int num) {
		double value = 0.0d;
		int i;
		if (num < oprandANum) {
			return BIGNUMBER;
		}
		Stack<Operator> operStack = new Stack<Operator>();
		Stack<Operand> oprStack = new Stack<Operand>();
		for (i = 0; i < operatorNum; i++) {
			operStack.push(operator[operatorNum - i - 1]);
		}
		for (i = 0; i < oprandNum; i++) {
			Operand od = oprandA[oprandNum - i - 1];
			for (int j = 0; j < oprandANum; j++) {
				if (od.equals(oprandA[j])) {
					od.name = String.valueOf(variantValue[j]);
				}
			}
			oprStack.push(od);
		}
		value = computer(operStack, oprStack);
		return value;
	}

	private double computer(Stack<Operator> operStack, Stack<Operand> oprStack) {
		double value = 0.0d;
		if (operStack.empty()) {
			if (oprStack.size() == 1) {
				Operand od = oprStack.peek();
				value = Double.parseDouble(od.name);
				od = null;
				return value;
			} else {
				if (!oprStack.empty()) {
					oprStack.clear();
				}
				return BIGNUMBER;
			}
		}
		Stack<Operator> tmpOO = new Stack<Operator>();
		Stack<Operand> tmpOD = new Stack<Operand>();
		Operator op = null, op1 = null;
		Operand oprand = null, oprand1 = null;

		op = operStack.pop();
		if (!operStack.empty())
			op1 = operStack.peek();

		while (op1 != null && (op1.level > op.level)) {
			tmpOO.push(op);
			if (op.type == Operator.BINARY) {
				if (!oprStack.empty()) {
					oprand = oprStack.pop();
					tmpOD.push(oprand);
				}
			}
			op = op1;
			operStack.pop();
			if (!operStack.empty())
				op1 = (Operator) operStack.peek();
			else
				op1 = null;
		}
		if (op.type == Operator.UNARY) {
			if (oprStack.empty()) {
				return BIGNUMBER;
			}
			oprand = oprStack.peek();
			double x = computing(op, oprand);
			oprand.name = String.valueOf(x);
			// FLOATTOWSTR(x,szstr,32);
			// WSTRTOSTR(szstr,oprand.m_name,16);
		} else {
			if (oprStack.empty()) {
				return BIGNUMBER;
			}
			oprand1 = oprStack.pop();
			if (oprStack.empty()) {
				return BIGNUMBER;
			}
			oprand = oprStack.peek();
			double x = computing(op, oprand1, oprand);
			oprand.name = String.valueOf(x);
			// FLOATTOWSTR(x,szstr,32);
			// WSTRTOSTR(szstr,oprand.m_name,16);
			oprand1 = null;
		}
		op = null;
		while (!tmpOO.empty()) {
			op = tmpOO.pop();
			operStack.push(op);
		}
		while (!tmpOD.empty()) {
			oprand = tmpOD.pop();
			oprStack.push(oprand);
		}
		return computer(operStack, oprStack);
	}

	private double computing(final Operator op, final Operand Loprand, final Operand Roprand) {
		double x = BIGNUMBER;
		switch (op.op) {
		case Operator.OP_OR: {
			int i1 = Integer.parseInt(Loprand.name);
			int i2 = Integer.parseInt(Roprand.name);
			x = BooleanToInt((i1 != 0 || i2 != 0));
			// x = BooleanToInt((int)(i1 || i2));
		}
			break;
		case Operator.OP_AND: {
			int i1 = Integer.parseInt(Loprand.name);
			int i2 = Integer.parseInt(Roprand.name);
			x = BooleanToInt((i1 != 0 && i2 != 0));
		}
			break;
		case Operator.OP_EQUAL: {
			double i1 = Double.parseDouble(Loprand.name);
			double i2 = Double.parseDouble(Roprand.name);
			boolean i = (Double.compare(i1, i2) == 0);
			x = BooleanToInt(i);
		}
			break;
		case Operator.OP_NOTEQUAL: {
			double i1 = Double.parseDouble(Loprand.name);
			double i2 = Double.parseDouble(Roprand.name);
			boolean i = (Double.compare(i1, i2) != 0);
			x = BooleanToInt(i);
		}
			break;
		case Operator.OP_GT: {
			double i1 = Double.parseDouble(Loprand.name);
			double i2 = Double.parseDouble(Roprand.name);
			boolean i = (Double.compare(i1, i2) > 0);
			x = BooleanToInt(i);
		}
			break;
		case Operator.OP_GE: {
			double i1 = Double.parseDouble(Loprand.name);
			double i2 = Double.parseDouble(Roprand.name);
			boolean i = (Double.compare(i1, i2) >= 0);
			x = BooleanToInt(i);
		}
			break;
		case Operator.OP_LT: {
			double i1 = Double.parseDouble(Loprand.name);
			double i2 = Double.parseDouble(Roprand.name);
			boolean i = (Double.compare(i1, i2) < 0);
			x = BooleanToInt(i);
		}
			break;
		case Operator.OP_LE: {
			double i1 = Double.parseDouble(Loprand.name);
			double i2 = Double.parseDouble(Roprand.name);
			boolean i = (Double.compare(i1, i2) <= 0);
			x = BooleanToInt(i);
		}
			break;
		case Operator.OP_ADD:
			x = Double.parseDouble(Loprand.name) + Double.parseDouble(Roprand.name);
			break;
		case Operator.OP_SUB:
			x = Double.parseDouble(Loprand.name) - Double.parseDouble(Roprand.name);
			break;
		case Operator.OP_MUL:
			x = Double.parseDouble(Loprand.name) * Double.parseDouble(Roprand.name);
			break;
		case Operator.OP_DIV: {
			double d1 = Double.parseDouble(Loprand.name);
			double d2 = Double.parseDouble(Roprand.name);
			if (!IsZero(d2)) {
				x = d1 / d2;
			}
		}
			break;
		default:
			break;
		}
		return x;
	}

	private double computing(final Operator op, final Operand oprand) {
		double x = Double.parseDouble(oprand.name);

		if (op.op == Operator.OP_NEG) {
			x = -x;
		} else if (op.op == Operator.OP_POS) {
			;
		} else if (op.op == Operator.OP_ASSIGN) {
			// oprand=(COperand*)Oprand.top();
			// DBGPRINTF("%d,%s",op->m_op,oprand->m_name);
		} else if (op.op == Operator.OP_NOT) {
			int b = Integer.parseInt(oprand.name) == 0 ? 1 : 0;
			// boolean b = ATOI(oprand.m_name);
			// b = !b;
			x = b;
		}
		return x;
	}

	public int getVariantCount() {
		return oprandANum;
	}

	public static void main(String args[]) {
		String formula = "c==a+b";
		StringResolution sr = new StringResolution(formula);
		double variantValue[] = new double[] { 3.0, 2.0, 1.0 };
		System.out.println(sr.getVariantCount());
		System.out.println(sr.computer(variantValue, sr.getVariantCount()));
		
		String s = "(a+b)*c+d";
		StringResolution sr1 = new StringResolution(s);
		System.out.println(sr1.getVariantCount());
		System.out.println(sr1.computer(new double[] {1.0, 3.7, 2.0, 4.5}, sr1.getVariantCount()));
	}

}
