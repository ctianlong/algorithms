<p>给你一个字符串 <code>path</code> ，表示指向某一文件或目录的&nbsp;Unix 风格 <strong>绝对路径 </strong>（以 <code>'/'</code> 开头），请你将其转化为 <strong>更加简洁的规范路径</strong>。</p>

<p class="MachineTrans-lang-zh-CN">在 Unix 风格的文件系统中规则如下：</p>

<ul> 
 <li class="MachineTrans-lang-zh-CN">一个点&nbsp;<code>'.'</code>&nbsp;表示当前目录本身。</li> 
 <li class="MachineTrans-lang-zh-CN">此外，两个点 <code>'..'</code>&nbsp;表示将目录切换到上一级（指向父目录）。</li> 
 <li class="MachineTrans-lang-zh-CN">任意多个连续的斜杠（即，<code>'//'</code>&nbsp;或 <code>'///'</code>）都被视为单个斜杠 <code>'/'</code>。</li> 
 <li class="MachineTrans-lang-zh-CN">任何其他格式的点（例如，<code>'...'</code>&nbsp;或 <code>'....'</code>）均被视为有效的文件/目录名称。</li> 
</ul>

<p>返回的 <strong>简化路径</strong> 必须遵循下述格式：</p>

<ul> 
 <li>始终以斜杠 <code>'/'</code> 开头。</li> 
 <li>两个目录名之间必须只有一个斜杠 <code>'/'</code> 。</li> 
 <li>最后一个目录名（如果存在）<strong>不能 </strong>以 <code>'/'</code> 结尾。</li> 
 <li>此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 <code>'.'</code> 或 <code>'..'</code>）。</li> 
</ul>

<p>返回简化后得到的 <strong>规范路径</strong> 。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">path = "/home/"</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>"/home"</span></p>

<p><strong>解释：</strong></p>

<p>应删除尾随斜杠。</p>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>path = "/home//foo/"</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>"/home/foo"</span></p>

<p><strong>解释：</strong></p>

<p>多个连续的斜杠被单个斜杠替换。</p>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">path = "/home/user/Documents/../Pictures"</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>"/home/user/Pictures"</span></p>

<p><strong>解释：</strong></p>

<p>两个点&nbsp;<code>".."</code>&nbsp;表示上一级目录（父目录）。</p>

<p><strong class="example">示例 4：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>path = "/../"</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>"/"</span></p>

<p><strong>解释：</strong></p>

<p>不可能从根目录上升一级目录。</p>

<p><strong class="example">示例 5：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>path = "/.../a/../b/c/../d/./"</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>"/.../b/d"</span></p>

<p><strong>解释：</strong></p>

<p><code>"..."</code>&nbsp;在这个问题中是一个合法的目录名。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= path.length &lt;= 3000</code></li> 
 <li><code>path</code> 由英文字母，数字，<code>'.'</code>，<code>'/'</code> 或 <code>'_'</code> 组成。</li> 
 <li><code>path</code> 是一个有效的 Unix 风格绝对路径。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 字符串</details><br>

<div>👍 843, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题比较简单，利用栈先进后出的特性处理上级目录 `..`，最后组装化简后的路径即可。

**详细题解**：
  - [【练习】栈的经典习题](https://labuladong.online/algo/problem-set/stack/)

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

#include <string>
#include <vector>
#include <sstream>

class Solution {
public:
    std::string simplifyPath(std::string path) {
        std::vector<std::string> parts;
        std::istringstream ss(path);
        std::string part;

        // 借助栈计算最终的文件夹路径
        while (std::getline(ss, part, '/')) {
            if (part.empty() || part == ".") {
                // Skip empty parts and current directory symbol.
                continue;
            }
            if (part == "..") {
                // Go up one directory (pop from the stack) unless the stack is empty.
                if (!parts.empty()) parts.pop_back();
            } else {
                // Add the non-empty and non-".." part to the stack.
                parts.push_back(part);
            }
        }

        // 栈中存储的文件夹组成路径
        std::string res;
        for (const auto& p : parts) {
            res += "/" + p;
        }

        // If the result is empty, it means the path is root directory.
        return res.empty() ? "/" : res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def simplifyPath(self, path: str) -> str:
        parts = path.split("/")
        stk = []
        # 借助栈计算最终的文件夹路径
        for part in parts:
            if part == "" or part == ".":
                continue
            if part == "..":
                if stk:
                    stk.pop()
                continue
            stk.append(part)
        # 栈中存储的文件夹组成路径
        res = ""
        while stk:
            res = "/" + stk.pop() + res
        return res if res else "/"
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stk = new Stack<>();
        // 借助栈计算最终的文件夹路径
        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stk.isEmpty()) stk.pop();
                continue;
            }
            stk.push(part);
        }
        // 栈中存储的文件夹组成路径
        String res = "";
        while (!stk.isEmpty()) {
            res = "/" + stk.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func simplifyPath(path string) string {
    parts := strings.Split(path, "/")
    stk := []string{}
    // 借助栈计算最终的文件夹路径
    for _, part := range parts {
        if part == "" || part == "." {
            continue
        }
        if part == ".." {
            if len(stk) > 0 {
                stk = stk[:len(stk)-1]
            }
            continue
        }
        stk = append(stk, part)
    }
    // 栈中存储的文件夹组成路径
    res := ""
    for _, dir := range stk {
        res += "/" + dir
    }
    if res == "" {
        return "/"
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var simplifyPath = function(path) {
    const parts = path.split("/");
    const stk = [];
    // 借助栈计算最终的文件夹路径
    for (const part of parts) {
        if (part === "" || part === ".") {
            continue;
        }
        if (part === "..") {
            if (stk.length > 0) stk.pop();
            continue;
        }
        stk.push(part);
    }
    // 栈中存储的文件夹组成路径
    let res = "";
    while (stk.length > 0) {
        res = "/" + stk.pop() + res;
    }
    return res === "" ? "/" : res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_simplify-path"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_simplify-path"></div></div>
</details><hr /><br />

</div>
</details>
</div>



