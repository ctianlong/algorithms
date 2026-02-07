<p>设计一个算法，该算法接受一个整数流并检索该流中最后 <code>k</code> 个整数的乘积。</p>

<p>实现&nbsp;<code>ProductOfNumbers</code>&nbsp;类：</p>

<ul> 
 <li><code>ProductOfNumbers()</code>&nbsp;用一个空的流初始化对象。</li> 
 <li><code>void add(int num)</code>&nbsp;将数字&nbsp;<code>num</code>&nbsp;添加到当前数字列表的最后面。</li> 
 <li><code>int getProduct(int k)</code>&nbsp;返回当前数字列表中，最后&nbsp;<code>k</code>&nbsp;个数字的乘积。你可以假设当前列表中始终 <strong>至少</strong> 包含 <code>k</code> 个数字。</li> 
</ul>

<p>题目数据保证：任何时候，任一连续数字序列的乘积都在 32 位整数范围内，不会溢出。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

<strong>输出：</strong>
[null,null,null,null,null,null,20,40,0,null,32]

<strong>解释：</strong>
ProductOfNumbers productOfNumbers = new ProductOfNumbers();
productOfNumbers.add(3);        // [3]
productOfNumbers.add(0);        // [3,0]
productOfNumbers.add(2);        // [3,0,2]
productOfNumbers.add(5);        // [3,0,2,5]
productOfNumbers.add(4);        // [3,0,2,5,4]
productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
productOfNumbers.add(8);        // [3,0,2,5,4,8]
productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32 
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= num&nbsp;&lt;=&nbsp;100</code></li> 
 <li><code>1 &lt;= k &lt;= 4 * 10<sup>4</sup></code></li> 
 <li><code>add</code> 和 <code>getProduct</code>&nbsp;最多被调用&nbsp;<code>4 * 10<sup>4</sup></code> 次。</li> 
 <li>在任何时间点流的乘积都在 32 位整数范围内。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>您能否 <strong>同时</strong> 将 <code>GetProduct</code> 和 <code>Add</code> 的实现改为 <code>O(1)</code> 时间复杂度，而不是 <code>O(k)</code> 时间复杂度？</p>

<details><summary><strong>Related Topics</strong></summary>设计 | 数组 | 数学 | 数据流 | 前缀和</details><br>

<div>👍 124, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

如果你看过前文 [小而美的算法技巧：前缀和数组](https://labuladong.online/algo/data-structure/prefix-sum/) 这道题就不难，前缀和和前缀积很类似，只不过乘积中如果有 0 需要特殊处理。

**详细题解**：
  - [【练习】前缀和技巧经典习题](https://labuladong.online/algo/problem-set/perfix-sum/)

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

#include <vector>

class ProductOfNumbers {
    // 前缀积数组
    // preProduct[i] / preProduct[j] 就是 [i, j] 之间的元素积
    std::vector<int> preProduct;

public:
    ProductOfNumbers() {
        // 初始化放一个 1，便于计算后续添加元素的乘积
        preProduct.push_back(1);
    }

    void add(int num) {
        if (num == 0) {
            // 如果添加的元素是 0，则前面的元素积都废了
            preProduct.clear();
            preProduct.push_back(1);
            return;
        }
        int n = preProduct.size();
        // 前缀积数组中每个元素
        preProduct.push_back(preProduct[n - 1] * num);
    }

    int getProduct(int k) {
        int n = preProduct.size();
        if (k > n - 1) {
            // 不足 k 个元素，是因为最后 k 个元素存在 0
            return 0;
        }
        // 计算最后 k 个元素积
        return preProduct[n - 1] / preProduct[n - k - 1];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class ProductOfNumbers:
    # 前缀积数组
    # preProduct[i] / preProduct[j] 就是 [i, j] 之间的元素积
    def __init__(self):
        # 初始化放一个 1，便于计算后续添加元素的乘积
        self.preProduct = [1]

    def add(self, num: int) -> None:
        if num == 0:
            # 如果添加的元素是 0，则前面的元素积都废了
            self.preProduct = [1]
            return
        # 前缀积数组中每个元素
        self.preProduct.append(self.preProduct[-1] * num)

    def getProduct(self, k: int) -> int:
        if k >= len(self.preProduct):
            # 不足 k 个元素，是因为最后 k 个元素存在 0
            return 0
        # 计算最后 k 个元素积
        return self.preProduct[-1] // self.preProduct[-k-1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class ProductOfNumbers {
    // 前缀积数组
    // preProduct[i] / preProduct[j] 就是 [i, j] 之间的元素积
    ArrayList<Integer> preProduct = new ArrayList<>();

    public ProductOfNumbers() {
        // 初始化放一个 1，便于计算后续添加元素的乘积
        preProduct.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            // 如果添加的元素是 0，则前面的元素积都废了
            preProduct.clear();
            preProduct.add(1);
            return;
        }
        int n = preProduct.size();
        // 前缀积数组中每个元素
        preProduct.add(preProduct.get(n - 1) * num);
    }

    public int getProduct(int k) {
        int n = preProduct.size();
        if (k > n - 1) {
            // 不足 k 个元素，是因为最后 k 个元素存在 0
            return 0;
        }
        // 计算最后 k 个元素积
        return preProduct.get(n - 1) / preProduct.get(n - k - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

type ProductOfNumbers struct {
    // 前缀积数组
    // preProduct[i] / preProduct[j] 就是 [i, j] 之间的元素积
    preProduct []int
}

func Constructor() ProductOfNumbers {
    // 初始化放一个 1，便于计算后续添加元素的乘积
    return ProductOfNumbers{preProduct: []int{1}}
}

func (this *ProductOfNumbers) Add(num int)  {
    if num == 0 {
        // 如果添加的元素是 0，则前面的元素积都废了
        this.preProduct = []int{1}
        return
    }
    // 前缀积数组中每个元素
    n := len(this.preProduct)
    this.preProduct = append(this.preProduct, this.preProduct[n-1] * num)
}

func (this *ProductOfNumbers) GetProduct(k int) int {
    n := len(this.preProduct)
    if k > n - 1 {
        // 不足 k 个元素，是因为最后 k 个元素存在 0
        return 0
    }
    // 计算最后 k 个元素积
    return this.preProduct[n-1] / this.preProduct[n-k-1]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var ProductOfNumbers = function() {
    // 前缀积数组
    // preProduct[i] / preProduct[j] 就是 [i, j] 之间的元素积
    this.preProduct = [1];
    // 初始化放一个 1，便于计算后续添加元素的乘积
};

ProductOfNumbers.prototype.add = function(num) {
    if (num === 0) {
        // 如果添加的元素是 0，则前面的元素积都废了
        this.preProduct = [1];
        return;
    }
    let n = this.preProduct.length;
    // 前缀积数组中每个元素
    this.preProduct.push(this.preProduct[n - 1] * num);
};

ProductOfNumbers.prototype.getProduct = function(k) {
    let n = this.preProduct.length;
    if (k > n - 1) {
        // 不足 k 个元素，是因为最后 k 个元素存在 0
        return 0;
    }
    // 计算最后 k 个元素积
    return this.preProduct[n - 1] / this.preProduct[n - k - 1];
};
```

</div></div>
</div></div>

</div>
</details>
</div>



