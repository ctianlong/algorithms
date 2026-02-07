<p>车上最初有&nbsp;<code>capacity</code>&nbsp;个空座位。车&nbsp;<strong>只能&nbsp;</strong>向一个方向行驶（也就是说，<strong>不允许掉头或改变方向</strong>）</p>

<p>给定整数&nbsp;<code>capacity</code>&nbsp;和一个数组 <code>trips</code> , &nbsp;<code>trips[i] = [numPassengers<sub>i</sub>, from<sub>i</sub>, to<sub>i</sub>]</code>&nbsp;表示第 <code>i</code> 次旅行有&nbsp;<code>numPassengers<sub>i</sub></code>&nbsp;乘客，接他们和放他们的位置分别是&nbsp;<code>from<sub>i</sub></code>&nbsp;和&nbsp;<code>to<sub>i</sub></code>&nbsp;。这些位置是从汽车的初始位置向东的公里数。</p>

<p>当且仅当你可以在所有给定的行程中接送所有乘客时，返回&nbsp;<code>true</code>，否则请返回 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>trips = [[2,1,5],[3,3,7]], capacity = 4
<strong>输出：</strong>false
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>trips = [[2,1,5],[3,3,7]], capacity = 5
<strong>输出：</strong>true
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= trips.length &lt;= 1000</code></li> 
 <li><code>trips[i].length == 3</code></li> 
 <li><code>1 &lt;= numPassengers<sub>i</sub>&nbsp;&lt;= 100</code></li> 
 <li><code>0 &lt;= from<sub>i</sub>&nbsp;&lt; to<sub>i</sub>&nbsp;&lt;= 1000</code></li> 
 <li><code>1 &lt;= capacity &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 前缀和 | 排序 | 模拟 | 堆（优先队列）</details><br>

<div>👍 438, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/diff-array/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

相信你已经能够联想到差分数组技巧了：**`trips[i]` 代表着一组区间操作，旅客的上车和下车就相当于数组的区间加减；只要结果数组中的元素都小于 `capacity`，就说明可以不超载运输所有旅客**。

这题还有一个细节，一批乘客从站点 `trip[1]` 上车，到站点 `trip[2]` 下车，呆在车上的站点应该是 `[trip[1], trip[2] - 1]`，这是需要被操作的索引区间。

**详细题解**：
  - [小而美的算法技巧：差分数组](https://labuladong.online/algo/data-structure/diff-array/)

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
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        // 最多有 1000 个车站
        vector<int> nums(1001, 0);
        // 构造差分解法
        Difference df(nums);

        for (const auto& trip : trips) {
            // 乘客数量
            int val = trip[0];
            // 第 trip[1] 站乘客上车
            int i = trip[1];
            // 第 trip[2] 站乘客已经下车，
            // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            int j = trip[2] - 1;
            // 进行区间操作
            df.increment(i, j, val);
        }

        vector<int> res = df.result();

        // 客车自始至终都不应该超载
        for (int i = 0; i < res.size(); i++) {
            if (capacity < res[i]) {
                return false;
            }
        }
        return true;
    }

    // 差分数组工具类
    class Difference {
    private:
        // 差分数组
        vector<int> diff;

    public:
        // 输入一个初始数组，区间操作将在这个数组上进行
        Difference(vector<int>& nums) {
            assert(!nums.empty());
            diff.resize(nums.size());
            // 根据初始数组构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.size(); i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        // 给闭区间 [i, j] 增加 val（可以是负数）
        void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.size()) {
                diff[j + 1] -= val;
            }
        }

        // 返回结果数组
        vector<int> result() {
            vector<int> res(diff.size());
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (int i = 1; i < diff.size(); i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    };
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        # 最多有 1000 个车站
        nums = [0] * 1001
        # 构造差分解法
        df = self.Difference(nums)

        for trip in trips:
            # 乘客数量
            val = trip[0]
            # 第 trip[1] 站乘客上车
            i = trip[1]
            # 第 trip[2] 站乘客已经下车，
            # 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            j = trip[2] - 1
            # 进行区间操作
            df.increment(i, j, val)

        res = df.result()

        # 客车自始至终都不应该超载
        for i in range(len(res)):
            if capacity < res[i]:
                return False
        return True

    # 差分数组工具类
    class Difference:
        # 差分数组
        def __init__(self, nums: List[int]):
            # 输入一个初始数组，区间操作将在这个数组上进行
            # 根据初始数组构造差分数组
            self.diff = [nums[0]] + [nums[i] - nums[i - 1] for i in range(1, len(nums))]

        # 给闭区间 [i, j] 增加 val（可以是负数）
        def increment(self, i: int, j: int, val: int) -> None:
            self.diff[i] += val
            if j + 1 < len(self.diff):
                self.diff[j + 1] -= val

        # 返回结果数组
        def result(self) -> List[int]:
            res = [self.diff[0]]
            # 根据差分数组构造结果数组
            for i in range(1, len(self.diff)):
                res.append(res[i - 1] + self.diff[i])
            return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 最多有 1000 个车站
        int[] nums = new int[1001];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] trip : trips) {
            // 乘客数量
            int val = trip[0];
            // 第 trip[1] 站乘客上车
            int i = trip[1];
            // 第 trip[2] 站乘客已经下车，
            // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
            int j = trip[2] - 1;
            // 进行区间操作
            df.increment(i, j, val);
        }

        int[] res = df.result();

        // 客车自始至终都不应该超载
        for (int i = 0; i < res.length; i++) {
            if (capacity < res[i]) {
                return false;
            }
        }
        return true;
    }

    // 差分数组工具类
    class Difference {
        // 差分数组
        private int[] diff;

        // 输入一个初始数组，区间操作将在这个数组上进行
        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            // 根据初始数组构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        // 给闭区间 [i, j] 增加 val（可以是负数）
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        // 返回结果数组
        public int[] result() {
            int[] res = new int[diff.length];
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func carPooling(trips [][]int, capacity int) bool {
    // 最多有 1000 个车站
    nums := make([]int, 1001)
    // 构造差分解法
    df := NewDifference(nums)

    for _, trip := range trips {
        // 乘客数量
        val := trip[0]
        // 第 trip[1] 站乘客上车
        i := trip[1]
        // 第 trip[2] 站乘客已经下车，
        // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
        j := trip[2] - 1
        // 进行区间操作
        df.Increment(i, j, val)
    }

    res := df.Result()

    // 客车自始至终都不应该超载
    for _, v := range res {
        if capacity < v {
            return false
        }
    }
    return true
}

// 差分数组工具类
type Difference struct {
    diff []int // 差分数组
}

// 输入一个初始数组，区间操作将在这个数组上进行
func NewDifference(nums []int) *Difference {
    // 根据初始数组构造差分数组
    diff := make([]int, len(nums))
    diff[0] = nums[0]
    for i := 1; i < len(nums); i++ {
        diff[i] = nums[i] - nums[i-1]
    }
    return &Difference{diff: diff}
}

// 给闭区间 [i, j] 增加 val（可以是负数）
func (d *Difference) Increment(i, j, val int) {
    d.diff[i] += val
    if j+1 < len(d.diff) {
        d.diff[j+1] -= val
    }
}

// 返回结果数组
func (d *Difference) Result() []int {
    // 根据差分数组构造结果数组
    res := make([]int, len(d.diff))
    res[0] = d.diff[0]
    for i := 1; i < len(d.diff); i++ {
        res[i] = res[i-1] + d.diff[i]
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var carPooling = function(trips, capacity) {
    // 最多有 1000 个车站
    const nums = new Array(1001).fill(0);
    // 构造差分解法
    const df = new Difference(nums);

    for (const trip of trips) {
        // 乘客数量
        const val = trip[0];
        // 第 trip[1] 站乘客上车
        const i = trip[1];
        // 第 trip[2] 站乘客已经下车，
        // 即乘客在车上的区间是 [trip[1], trip[2] - 1]
        const j = trip[2] - 1;
        // 进行区间操作
        df.increment(i, j, val);
    }

    const res = df.result();

    // 客车自始至终都不应该超载
    for (let i = 0; i < res.length; i++) {
        if (capacity < res[i]) {
            return false;
        }
    }
    return true;
};

// 差分数组工具类
class Difference {
    // 输入一个初始数组，区间操作将在这个数组上进行
    // 根据初始数组构造差分数组
    constructor(nums) {
        // 差分数组
        this.diff = [...nums];
        this.diff[0] = nums[0];
        for (let i = 1; i < nums.length; i++) {
            this.diff[i] = nums[i] - nums[i - 1];
        }
    }

    // 给闭区间 [i, j] 增加 val（可以是负数）
    increment(i, j, val) {
        this.diff[i] += val;
        if (j + 1 < this.diff.length) {
            this.diff[j + 1] -= val;
        }
    }

    // 返回结果数组
    result() {
        const res = new Array(this.diff.length);
        // 根据差分数组构造结果数组
        res[0] = this.diff[0];
        for (let i = 1; i < this.diff.length; i++) {
            res[i] = res[i - 1] + this.diff[i];
        }
        return res;
    }
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_car-pooling"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_car-pooling"></div></div>
</details><hr /><br />

</div>
</details>
</div>

