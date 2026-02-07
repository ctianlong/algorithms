<p>只有满足下面几点之一，括号字符串才是有效的：</p>

<ul> 
 <li>它是一个空字符串，或者</li> 
 <li>它可以被写成&nbsp;<code>AB</code>&nbsp;（<code>A</code>&nbsp;与&nbsp;<code>B</code>&nbsp;连接）, 其中&nbsp;<code>A</code> 和&nbsp;<code>B</code>&nbsp;都是有效字符串，或者</li> 
 <li>它可以被写作&nbsp;<code>(A)</code>，其中&nbsp;<code>A</code>&nbsp;是有效字符串。</li> 
</ul>

<p>给定一个括号字符串 <code>s</code> ，在每一次操作中，你都可以在字符串的任何位置插入一个括号</p>

<ul> 
 <li>例如，如果 <code>s = "()))"</code> ，你可以插入一个开始括号为 <code>"(()))"</code> 或结束括号为 <code>"())))"</code> 。</li> 
</ul>

<p>返回 <em>为使结果字符串 <code>s</code> 有效而必须添加的最少括号数</em>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "())"
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "((("
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 1000</code></li> 
 <li><code>s</code> 只包含&nbsp;<code>'('</code> 和&nbsp;<code>')'</code>&nbsp;字符。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 贪心 | 字符串</details><br>

<div>👍 278, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

判断括号有效性的方法一般都是从左到右遍历，根据左括号和右括号的数量对比来判断是否是有效的括号串。

本题是类似的，具体可以看代码和注释。**核心思路是以左括号为基准，通过维护对右括号的需求数 `need`，来计算最小的插入次数**。

需要注意两个地方：

1、当 `need == -1` 的时候意味着什么？

因为只有遇到右括号 `)` 的时候才会 `need--`，`need == -1` 意味着右括号太多了，所以需要插入左括号。

比如说 `s = "))"` 这种情况，需要插入 2 个左括号，使得 `s` 变成 `"()()"`，才是一个有效括号串。

2、算法为什么返回 `res + need`？

因为 `res` 记录的左括号的插入次数，`need` 记录了右括号的需求，当 for 循环结束后，若 `need` 不为 0，那么就意味着右括号还不够，需要插入。

比如说 `s = "))("` 这种情况，插入 2 个左括号之后，还要再插入 1 个右括号，使得 `s` 变成 `"()()()"`，才是一个有效括号串。

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
    int minAddToMakeValid(string s) {
        // res 记录插入次数
        int res = 0;
        // need 变量记录右括号的需求量
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(') {
                // 对右括号的需求 + 1
                need++;
            }

            if (s[i] == ')') {
                // 对右括号的需求 - 1
                need--;

                if (need == -1) {
                    need = 0;
                    // 需插入一个左括号
                    res++;
                }
            }
        }

        return res + need;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        # res 记录插入次数
        res = 0
        # need 变量记录右括号的需求量
        need = 0

        for i in range(len(s)):
            if s[i] == '(':
                # 对右括号的需求 + 1
                need += 1

            if s[i] == ')':
                # 对右括号的需求 - 1
                need -= 1

                if need == -1:
                    need = 0
                    # 需插入一个左括号
                    res += 1

        return res + need
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int minAddToMakeValid(String s) {
        // res 记录插入次数
        int res = 0;
        // need 变量记录右括号的需求量
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 对右括号的需求 + 1
                need++;
            }

            if (s.charAt(i) == ')') {
                // 对右括号的需求 - 1
                need--;

                if (need == -1) {
                    need = 0;
                    // 需插入一个左括号
                    res++;
                }
            }
        }

        return res + need;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func minAddToMakeValid(s string) int {
    // res 记录插入次数
    res := 0
    // need 变量记录右括号的需求量
    need := 0

    for i := 0; i < len(s); i++ {
        if s[i] == '(' {
            // 对右括号的需求 + 1
            need++
        }

        if s[i] == ')' {
            // 对右括号的需求 - 1
            need--

            if need == -1 {
                need = 0
                // 需插入一个左括号
                res++
            }
        }
    }

    return res + need
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var minAddToMakeValid = function(s) {
    // res 记录插入次数
    let res = 0;
    // need 变量记录右括号的需求量
    let need = 0;

    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') {
            // 对右括号的需求 + 1
            need++;
        }

        if (s[i] === ')') {
            // 对右括号的需求 - 1
            need--;

            if (need === -1) {
                need = 0;
                // 需插入一个左括号
                res++;
            }
        }
    }

    return res + need;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_minimum-add-to-make-parentheses-valid"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-add-to-make-parentheses-valid"></div></div>
</details><hr /><br />

</div>
</details>
</div>



