<p>给你一个字符串 <code>s</code> ，请你反转字符串中 <strong>单词</strong> 的顺序。</p>

<p><strong>单词</strong> 是由非空格字符组成的字符串。<code>s</code> 中使用至少一个空格将字符串中的 <strong>单词</strong> 分隔开。</p>

<p>返回 <strong>单词</strong> 顺序颠倒且 <strong>单词</strong> 之间用单个空格连接的结果字符串。</p>

<p><strong>注意：</strong>输入字符串 <code>s</code>中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "the sky is blue"
<strong>输出：</strong>"blue is sky the"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = " &nbsp;hello world &nbsp;"
<strong>输出：</strong>"world hello"
<strong>解释：</strong>反转后的字符串中不能存在前导空格和尾随空格。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "a good &nbsp; example"
<strong>输出：</strong>"example good a"
<strong>解释：</strong>如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>s</code> 包含英文大小写字母、数字和空格 <code>' '</code></li> 
 <li><code>s</code> 中 <strong>至少存在一个</strong> 单词</li> 
</ul>

<ul> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用&nbsp;<code>O(1)</code> 额外空间复杂度的 <strong>原地</strong> 解法。</p>

<details><summary><strong>Related Topics</strong></summary>双指针 | 字符串</details><br>

<div>👍 1360, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

常规方法是用类似 `split` 再 `reverse` 最后 `join` 的方法得到结果，但更巧妙的方法是我在 [二维数组的花式遍历](https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/) 中讲到的：**先把整个字符串进行翻转，再把每个单词中的字母翻转**。

比如说，给你输入这样一个字符串：

```java
s = "hello world labuladong"
```

那么我们先将整个字符串 `s` 反转：

```java
s = "gnodalubal dlrow olleh"
```

**然后将每个单词分别反转**：

```java
s = "labuladong world hello"
```

这样，就实现了原地反转所有单词顺序的目的。

整体的思路应该不难，就是细节比较恶心，直接看我写的代码吧。

**详细题解**：
  - [二维数组的花式遍历技巧](https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/)

</div>





<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution {
public:
    string reverseWords(string s) {
        stringstream ss;
        // 先清洗一下数据，把多于的空格都删掉
        for (int i = 0; i < s.length(); i++) {
            char c = s[i];
            if (c != ' ') {
                // 单词中的字母/数字
                ss << c;
            } else if (!ss.str().empty() && ss.str().back() != ' ') {
                // 单词之间保留一个空格
                ss << ' ';
            }
        }

        string cleaned = ss.str();
        if (cleaned.empty()) {
            return "";
        }
        // 末尾如果有空格，清除之
        if (cleaned.back() == ' ') {
            cleaned.pop_back();
        }

        // 清洗之后的字符串
        vector<char> chars(cleaned.begin(), cleaned.end());
        int n = chars.size();
        // 进行单词的翻转，先整体翻转
        reverse(chars, 0, n - 1);
        // 再把每个单词翻转
        for (int i = 0; i < n; ) {
            for (int j = i; j < n; j++) {
                if (j + 1 == n || chars[j + 1] == ' ') {
                    // chars[i..j] 是一个单词，翻转之
                    reverse(chars, i, j);
                    // 把 i 置为下一个单词的首字母
                    i = j + 2;
                    break;
                }
            }
        }
        // 最后得到题目想要的结果
        return string(chars.begin(), chars.end());
    }

    // 翻转 arr[i..j]
    void reverse(vector<char>& arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def reverseWords(self, s: str) -> str:
        sb = []
        # 先清洗一下数据，把多于的空格都删掉
        for c in s:
            if c != ' ':
                # 单词中的字母/数字
                sb.append(c)
            elif sb and sb[-1] != ' ':
                # 单词之间保留一个空格
                sb.append(' ')
        if not sb:
            return ""
        # 末尾如果有空格，清除之
        if sb[-1] == ' ':
            sb.pop()

        # 清洗之后的字符串
        chars = list(''.join(sb))
        n = len(chars)
        # 进行单词的翻转，先整体翻转
        self.reverse(chars, 0, n - 1)
        # 再把每个单词翻转
        i = 0
        while i < n:
            for j in range(i, n):
                if j + 1 == n or chars[j + 1] == ' ':
                    # chars[i..j] 是一个单词，翻转之
                    self.reverse(chars, i, j)
                    # 把 i 置为下一个单词的首字母
                    i = j + 2
                    break
        
        # 最后得到题目想要的结果
        return ''.join(chars)

    # 翻转 arr[i..j]
    def reverse(self, arr, i, j):
        while i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // 先清洗一下数据，把多于的空格都删掉
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                // 单词中的字母/数字
                sb.append(c);
            } else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                // 单词之间保留一个空格
                sb.append(' ');
            }
        }
        if (sb.isEmpty()) {
            return "";
        }
        // 末尾如果有空格，清除之
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 清洗之后的字符串
        char[] chars = sb.toString().toCharArray();
        int n = chars.length;
        // 进行单词的翻转，先整体翻转
        reverse(chars, 0, n - 1);
        // 再把每个单词翻转
        for (int i = 0; i < n; ) {
            for (int j = i; j < n; j++) {
                if (j + 1 == n || chars[j + 1] == ' ') {
                    // chars[i..j] 是一个单词，翻转之
                    reverse(chars, i, j);
                    // 把 i 置为下一个单词的首字母
                    i = j + 2;
                    break;
                }
            }
        }
        // 最后得到题目想要的结果
        return new String(chars);
    }

    // 翻转 arr[i..j]
    void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func reverseWords(s string) string {
    var sb strings.Builder
    // 先清洗一下数据，把多于的空格都删掉
    for i := 0; i < len(s); i++ {
        c := s[i]
        if c != ' ' {
            // 单词中的字母/数字
            sb.WriteByte(c)
        } else if sb.Len() > 0 && sb.String()[sb.Len()-1] != ' ' {
            // 单词之间保留一个空格
            sb.WriteByte(' ')
        }
    }
    if sb.Len() == 0 {
        return ""
    }
    // 末尾如果有空格，清除之
    cleaned := sb.String()
    if cleaned[len(cleaned)-1] == ' ' {
        cleaned = cleaned[:len(cleaned)-1]
    }

    // 清洗之后的字符串
    chars := []byte(cleaned)
    n := len(chars)
    // 进行单词的翻转，先整体翻转
    reverse(chars, 0, n-1)
    // 再把每个单词翻转
    for i := 0; i < n; {
        for j := i; j < n; j++ {
            if j+1 == n || chars[j+1] == ' ' {
                // chars[i..j] 是一个单词，翻转之
                reverse(chars, i, j)
                // 把 i 置为下一个单词的首字母
                i = j + 2
                break
            }
        }
    }
    // 最后得到题目想要的结果
    return string(chars)
}

// 翻转 arr[i..j]
func reverse(arr []byte, i, j int) {
    for i < j {
        arr[i], arr[j] = arr[j], arr[i]
        i++
        j--
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var reverseWords = function(s) {
    let sb = '';
    // 先清洗一下数据，把多于的空格都删掉
    for (let i = 0; i < s.length; i++) {
        let c = s.charAt(i);
        if (c !== ' ') {
            // 单词中的字母/数字
            sb += c;
        } else if (sb.length > 0 && sb.charAt(sb.length - 1) !== ' ') {
            // 单词之间保留一个空格
            sb += ' ';
        }
    }
    if (sb.length === 0) {
        return "";
    }
    // 末尾如果有空格，清除之
    if (sb.charAt(sb.length - 1) === ' ') {
        sb = sb.slice(0, sb.length - 1);
    }

    // 清洗之后的字符串
    let chars = sb.split('');
    let n = chars.length;
    // 进行单词的翻转，先整体翻转
    reverse(chars, 0, n - 1);
    // 再把每个单词翻转
    for (let i = 0; i < n; ) {
        for (let j = i; j < n; j++) {
            if (j + 1 === n || chars[j + 1] === ' ') {
                // chars[i..j] 是一个单词，翻转之
                reverse(chars, i, j);
                // 把 i 置为下一个单词的首字母
                i = j + 2;
                break;
            }
        }
    }
    // 最后得到题目想要的结果
    return chars.join('');
};

// 翻转 arr[i..j]
function reverse(arr, i, j) {
    while (i < j) {
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_reverse-words-in-a-string"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-words-in-a-string"></div></div>
</details><hr /><br />

</div>
</details>
</div>

