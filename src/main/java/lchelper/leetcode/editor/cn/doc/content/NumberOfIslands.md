<p>给你一个由&nbsp;<code>'1'</code>（陆地）和 <code>'0'</code>（水）组成的的二维网格，请你计算网格中岛屿的数量。</p>

<p>岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。</p>

<p>此外，你可以假设该网格的四条边均被水包围。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 300</code></li> 
 <li><code>grid[i][j]</code> 的值为 <code>'0'</code> 或 <code>'1'</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 2476, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**



<p><strong><a href="https://labuladong.online/algo/slug.html?slug=number-of-islands" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

岛屿系列问题可以用 DFS/BFS 算法或者 [Union-Find 并查集算法](https://labuladong.online/algo/fname.html?fname=UnionFind算法详解) 来解决。

用 DFS 算法解决岛屿题目是最常见的，每次遇到一个岛屿中的陆地，就用 DFS 算法吧这个岛屿「淹掉」。

如何使用 DFS 算法遍历二维数组？你把二维数组中的每个格子看做「图」中的一个节点，这个节点和周围的四个节点连通，这样二维矩阵就被抽象成了一幅网状的「图」。

为什么每次遇到岛屿，都要用 DFS 算法把岛屿「淹了」呢？主要是为了省事，避免维护 `visited` 数组。

[图算法遍历基础](https://labuladong.online/algo/fname.html?fname=图) 说了，遍历图是需要 `visited` 数组记录遍历过的节点防止走回头路。

因为 `dfs` 函数遍历到值为 `0` 的位置会直接返回，所以只要把经过的位置都设置为 `0`，就可以起到不走回头路的作用。

**详细题解：[一文秒杀所有岛屿题目](https://labuladong.online/algo/fname.html?fname=岛屿题目)**

**标签：[DFS 算法](https://labuladong.online/algo/)，二维矩阵**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
    // 主函数，计算岛屿数量
public:
    int numIslands(vector<vector<char>>& grid) {
        int res = 0;
        int m = grid.size(), n = grid[0].size();
        // 遍历 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 然后使用 DFS 将岛屿淹了
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

private:
    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(vector<vector<char>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        m = len(grid)
        n = len(grid[0])
        # 遍历 grid
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    # 每发现一个岛屿，岛屿数量加一
                    res += 1
                    # 然后使用 DFS 将岛屿淹了
                    self.dfs(grid, i, j)
        return res

    # 从 (i, j) 开始，将与之相邻的陆地都变成海水
    def dfs(self, grid: List[List[str]], i: int, j: int) -> None:
        m = len(grid)
        n = len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            # 超出索引边界
            return
        if grid[i][j] == '0':
            # 已经是海水了
            return
        # 将 (i, j) 变成海水
        grid[i][j] = '0'
        # 淹没上下左右的陆地
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j - 1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数，计算岛屿数量
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        // 遍历 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 然后使用 DFS 将岛屿淹了
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func numIslands(grid [][]byte) int {
    res := 0
    m, n := len(grid), len(grid[0])
    // 遍历 grid
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == '1' {
                // 每发现一个岛屿，岛屿数量加一
                res++
                // 然后使用 DFS 将岛屿淹了
                dfs(grid, i, j)
            }
        }
    }
    return res
}

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
func dfs(grid [][]byte, i, j int) {
    m, n := len(grid), len(grid[0])
    if i < 0 || j < 0 || i >= m || j >= n {
        // 超出索引边界
        return
    }
    if grid[i][j] == '0' {
        // 已经是海水了
        return
    }
    // 将 (i, j) 变成海水
    grid[i][j] = '0'
    // 淹没上下左右的陆地
    dfs(grid, i+1, j)
    dfs(grid, i, j+1)
    dfs(grid, i-1, j)
    dfs(grid, i, j-1)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var numIslands = function(grid) {
    var res = 0;
    var m = grid.length, n = grid[0].length;
    // 遍历 grid
    for (var i = 0; i < m; i++) {
        for (var j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
                // 每发现一个岛屿，岛屿数量加一
                res++;
                // 然后使用 DFS 将岛屿淹了
                dfs(grid, i, j);
            }
        }
    }
    return res;
};

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
function dfs(grid, i, j) {
    var m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n) {
        // 超出索引边界
        return;
    }
    if (grid[i][j] == '0') {
        // 已经是海水了
        return;
    }
    // 将 (i, j) 变成海水
    grid[i][j] = '0';
    // 淹没上下左右的陆地
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_number-of-islands" data="W53VMTMqbJyA4Yd3LBphgfPIIFD542YhsHEASMJrANX6eEOkRvwPtDDLdMmulEL4cBJ5X9IsDtcr4XB6WtbSlF06BJXgsfgnzdX4U/y84jPAHWXkluPfK3ub9j+3dxCIdTsx5QWruv85p7JvwClKVL0KM5lkwMkQv3CuqKb5601I3kke2/NDvKdVspsQ0Kq9xaVG1w3G5qZ1cBtUrNgs3/mLN50YzAR4zHlcN6SYAxwYpIPzQs67mORQRt3/Wtt67SMWMsQrAVOpq28wSyaNSCjMN0ytZ3IjborEg/9/9/aKzVIahM/1prsTkgqgKH75S6ncA2AASQw4fpLbORLZdyYVsDhoCvzX71fWup29L9gJGzUxCkhpEmb/9O0TholONMLfCZEwJImMS8W6CBX4jx/7FdUaHi8tQfT08FPCEwZfEUv8Hze6JfdZqUOCIXp7nbNGzydhnfhNqe5AojVcTaifOHi39GVfw6Kby9oSZp9FDLkYVMlipUgwm7MIxTTvfnzz/bNx3ujfjeeol4Rm1NE6w8BKP2tjDt2R4fVJ/G61IWZ8ecr4eF6Uo/cq8e4vTIEE+PeGGNXpx0mslkFmorwHxsFD91nJxdTQT7EiTPNl/vw+PrBQb8pdubu/GAFrpcDZHEBQ63QMWx04vXusc3V7U26JgjQaVH0bCiMd0S9LulSnh9spQaz27nmiRNuI/kZQ8V129J4Sl74sOYLIb8zg19+Jo37vjDbbC/tzkm/vn8x9OJjxQUGww9X6vPdVzGX8Xj63M6SfflQHvUpUOFJnNUksL8y7I4s8S27ImT0v1/2RrCMYB17frN+xsC7N/hdZO3/ynuFxxJzX2RChno0PYd3LdzwVyZ4isIsPXZz9L559ZWOWd4b1zDJv6cIqFDhIz+BcO99pgsCNFREP+Sb0qM9Ja5bbC0p1+J0UWZ31ojLFjCPUpoyj4jAz6lksde8L7LPiVePTQB8wHp0qH0jEdIX98xoUByqErJRip9TwaCns10fVsYXzkZOzwAErbiDFWJWqINQ7F9AVBVKbUO2j+sROLtYr6J5V4SPYPUThFgWsgSw3NGKQ6TN78IBFhAAE3qkoSGtOq5kwRu/uR8Nfg/3id8/ef6VrruFqwyJiIQWa+LIRpXPZsHoQ/DbwXC/IpcZZtG/Vq6UfrCM00PZKBQztvtiqY2M94+E96/LtC6ObTVmjnnHVa9EyHkjgyFBVPWuQvjP0x/T1o66cYXG7kvJvDVPp8hH3Hk/hBkIM04DqplavBoB3Lwhxq5LO9bpeAD+Cb+iPqldVoBOMJQLwaCChaLFIMI7ROybQQvwVISSMMHPF9BKHCDFRhFkrFhAH27YCkEyMWZtqhUR+BIPIHoUI2HaWq1k7T4fBOgK+LBL2X2DzUM2I6VirFVjyqBs38uqGyV7V6DOu7pHFT5mzOjNw7pkpzYW2jBMMHyV+ySxoCQVNNqyvhhY0tlzTfmyg2Ihig8WGajdw/XJsxKnK74hvb+Meywv9fqNNVOQHbj2t8wQEKb39QC60kdHZQUncwYaWfK2XA71ZkyHpljVpExtVcHSJD+3FJrAZ7g75y9yFpSpfo+F8CpYX+v1GW6jUB26ddapTeiciQkOTN3CPA9nIUie5vbjtl7UYiu5Yi7awaWwmNgucTXxor7sjgBfWDrxCqcMBLQteKHeCggvw2u9mo+w9mY6887vnmf98kJmbNcCv6J7by5Pr69k1ojpj/VL7ojH3bPgA6f8rkDLL4wgPif568U/5m7hr8OgXOWeXPMveUrg/BM3Y67DSCNoyTnQWwkYMTfdYm7axFdgitoQtYyuxVfKp7eZibjWOto7qDyahRozswoUqNCJpHIjEOJqe2/K+mmHoPusQD+3FNrAd2Ca2hW3L51yLtZsL7Vbj4pqlfTshX2gAQevknlg9iXPZ0JInWrNqVYbFBcq6tIvtwnZje7C92AF2QsJQjK/n9XCBHR+GfGaw7jDf0H4uOSF8o71vezcUjoN8d0Bh20l9sRkOF1HWoz3sCDvGToKnZrHEm/jw26MKy1Ddv9eIS0tYDAFqOM9Y6clMl/H1zKJYi+PRJeujfdgN7BK7wq6xm9gtjt05KyD1GwzL8CzapWWuZBzi+2u12k5qQRyfrlg/7cfuYHexB+wF9og9STgLcH0veRbt0iZiI4OzgyefPofEwKnd256sLSNw0bXUQLGBYi+xV9hr7A32Fvsg4cUZ33eBrPoth9qU8DjtAFUtbzp8tup7RNQarsa3HXqnt1hgdDVeWy9tFftc7EvsK+xr7BuOt79WROo3H04sScdcxTgsMbh+q+3Jm3Ek4eFN2sR+YH9gP7Ff2G/sTxm/xOyt8mh7JHobE367O4QdXazqGxVyHIg5i7Nnu7zFUMAM3iIu4mPz92y49VJHqaPUUY7YdUu2Jpaku4IrsL09UelAGGezkaVe8z6fohdDA5O8TdvgQMGBggMFBwoOFBxRGRF1d6hb1dGeLyoPDxkRw92h7eRi5ezsNg4knJNxZr5yC+KYXTh5J/EED4GHwSPBo9CjqY8W9+IKWP0VLmiOPOVWwDV8fcZKV7pzTc6ONzkW4eJdxAucAU6CU+A0OBOcxZFn34poydW5wLq2VecoPSIzMjs7Mn3ZHDOjy6aWPtm1GlNzWo5NuHk39aY+xBdcAFeAi+ASR+3LFfO36gssA/vNSN8JuKbq7JELzXi0vU7LWxyH8PAe4gOuBFeBq8E14Fpwg6X35QrY+umAvdDu8F+rOzMR/8bh7UNPNyAOpJy3O+8ARW8zXGCB9xLfAW6CW+A2uBPcBe6W0NOxQE2sPGGgvrLZc5jyMdr6e7p+t/7bVkrcG0UPKaC6sr4uM8E4PfWFJCRwFVIT4AS4FzwBngGeBE+BpyXMdBfE+tszbdCIGwRRe+0H6//j7Zo+ZGAon6VyOcn1yTGf0dszXI5BWLyDRChfXuX6a87xGfvg172KnV1ot8sw7k79C3AA54uk+qR9pB3pTb6p6rACaxxjzXOXO5d1OBJX5k1wMvAs8GzwHPBc8AJ4hYzFlQ0RWZ+ZtakgcVl9MlfSlZuzembBbKR3OYpw8RZldfSlJm3zGmxBC3RvT9Q4kMbZnHcfu96Nowk3bxM3eAm8TL0u9KqoN/XhuCKm/r52Z1aZC9GmyUoDIevkzNlI73FMwss7SWekS3om9mhTYPX29DQDYZyL8z2ZJ2/HsIAN3kW8wBvgHeBN8BZ4G7xTwi53wVH/1J4OWUHmwrQ1EzlXbSDS8nmk2453ODZh8m7qTb2pD/EFH4BPgA8lHPVdIKp+mFmai6RtczUGYk0/wHLnxLsch7B4D/EBH4NPok9Rb+pDfCVc3OFbxOqvMytzUbSzH9dc7ROiGcgG552cP97juITNe4kv+Ab4EnwFvgbfRN/i2CshZWlmTbpX2QEI3dxtfhySWZhs6ic/OdF0jyh4ySjQTakFcMHd2qmftP/kkNKowxVRcyGH2238wcwdVowntz6OY63HQ54ZKO+beXAMwsU7qAfx/dshwIGCIwoOFhwqNlz/RiLX1ajqgZE/20ZyNo2VzBUfd8BAcjVm2t40Zn0yinRbahFb9E8napZLvakP8QUPgEfIGDy4U3bMbGjvMFkyELPWOi7nmMyv5ijCy1u05R/NEDZY2jKxNhemPXNlA3nGXl3TeLyfoYED3ibuCR4GjwSPQo+mPsRXQsJdSNTnmTZsIoHZ23RlavvM386avF+LAYdpO9rCRq5K0S4T27Sz0WKyykDKuNY8tB5vcqxJWLyLeGEzoj2k1wFLmIu64T1GTr8+sY/MpwS/UZv/hKgf6PiqXyTlVf9W6DroXT999iH2m/zHbE0oaNh4bZVGb9/9c/zIto83x6+mJc/AoOVtcKTtPgQG6URX2lJnIPQ9+cNRZOsxlmozsrT0GWgjTJmjqfZjANt6ZGWZ33rcGX6vfp+eEi/lWTY+EIc32H9D8xHHMi4yQD08/0zEmQVt/wmaqBwmWfrVkfXprLT786elpbUufkU5VkTWd+3FKL2LcZyIqu/aZVRdjOOJ6PquLUbTxTi+gKnvW4/RpWSbHStoS15o+mSnWdMASRf3Y7Ge1pE92rsYvT5+RRmGiK+P9kkEVB+/pAyJCvxxzuCyqaXNbX2Mo0RE/U3caWnqYxwtgPW3zcdJi3DaJEtLXWjom2iLtYxQtvunYVxnnQjWR/tkgmuEYlhfUhGqj/gzSn2MYYtw/VX8GJU+xnBEpP4qHkatjzFcAa2/bj5OE22RlaWRDbi9On8Uv08CxzT9gX/wB8zeosOSSM86s4dtfWm7HRqGqAyhHz/tWOdT5TT2TTm3QdDHG1wfXfFrQi1DSnZQ9DlqyNageB2Q2+yuy+Gxf0rO+crj8OdMP46ntcvaJBYkmSnd9vDaf/aJ+AcOGxJOAB8ikoowANReCIEhAgAqYwQod4gCigxiQrmFCCGhOK4XNnuahbVHavuqGJ6YfTRxVpfjnF2HUa9nTWmiPoYlw0sJaKaTxOKYaxte6t6HWQBAjN3u0T2z6nrGrSdDxszCWYjLnXvaYMzO5tX4oUoeqG1laFR5agkUKNZvam50dmrgW1MK5xU7hZS1nUr7oUYwevVDvWi/lFuGTQCZDuX7BNTDy2SUGl8QZQBoRo07Sk9Jeq7sNXYzYJqoku3hqMnTe1PTC8ioa8+MTihKuPFtPlQBw1DlqB1QxjDZqbGhfnjB0eZjqFXzmJSueS9UvSRo1JSgSqpa4rIXUVDBOqaEviRR8MydUg58nBROgxGlOJeDYpkv5HaXQHKdGKot9abi+5SF8opWR6V3njulddZJPePdQJ/X7YbLlHL5vpFq2UVBtdxq9KonHTQPVGzvvlLewqapEbeuv1gc+w1KYjXQbeVJpIyGSkpb6lICmJsPbXEdFApcGFCky4Yp2PxzfrFwap0mai5vfykV+35htZbuQu0HHV79wsswVAcRLpQsD68Y13A9oQA7s5cWv8M4qA2deL24h2HzTC3p0EFVNN7oBoPqB5PWvfKS/YUcVH56o9S90D7cwhr9KnOhBt0K9XZj8Bczmt02TyFGNQULIugv5mkCGaUGJMNT3Jw7qYROaqh/u50OBhWt1JB9N1S6uSFU5/meVLadW8oOs1QvOorChmrvuiKsDMGPUOeoNwXXrSd1T0cztUR+ipeuL48fY/X64oMWP5RMXxz1Y1s1hUIER/2d4Zfih547NZfOFHVKJDvl2tBMtYwWRHVVLaPeBIKhAEPvqX4Tyam2EsiohTPWlLmHlaX7Bm64SZ/xyzWifb/C2h3jGyx+CqZ8mr58NnKvc68rbs6So+/h516lo2B2vQohHLXtGXRGBvgu25axhj1zErdeMwlgZlS0f9cT3/M7i+6yqMJymB3FwE5wwlWFAFkAM11h1knoMtQyh6k2SQ66+US7qs1aYlSWyRYzo+1YXxJ/Ze98bpFGJjNMP0aucI0Y0ewuftyjkzRMsi4xycSZ1QibSjITOW9Gkbh0RcJVbVRw1NdCgL0tQmftkjm9N6OT5fskrlatV0/KWaP79SqOZGvAKdL9ehV7kYnVJO5YrzJI97gAYzH5amab8opUzj8UGr0TN1SHviK/ZVex160atRd8+/1Vr3LZ5CKxZ2Ylja70SDJsjYIosj37KrSif2e15pGX0oTjLhcOZUH0FhmLfcxy2dRzqYv+4JsNDQubyoZ1uvsr+6qhKIvnp6xwGD7XcdBrOKjONyJ6HGHfhu/jGrsGJJItMwn41c/ToDn3EeDxDW9Ztwz/z4cj6pMU7kTOcXX4cdbLVQOqrCji4uge3/rKoUbnjWCNcqNm1vrLZOLEO0j4toJwuUANutzq97Ev0UY0iF4io7NXBFY1E8qwvcJfZd+B0i3wtju9coJhLQ0ZwDrt/h7q/PMcKHdspSEAXJ7hC/iELtq+36MSWpPSpS55FPKvz6/s5+Fi7t2IpjWHSlow2BXBMLu0mtK1A6k9HWfORLTZrPcSS37adbAWNMvs4zH2A5Lsd354v37ed7TI7Wbhc5u8EyplMIRFsIXcNxulWkyXCey/5kYrPOCFjv+IjA7bciwUrtXG3hbfbezYaXQXxdiTlsk7EFoPW9F8GLQfxhoWsELEoPkwqDiMNRlghYVBL2FQPxhrGcDKBIPOwKAaMNYAcCYO/dPzJ9vvOs8Rflr7JPVdzjmQTwef3L2rNsfradSTondx5rA8/Xgy8a7BHH2n7U7C3aWWg+x018mru6JyLJ0mOulzF04OmdMrJ0vu+siRcVriJMNdBjkATuebnLerHce5aXCT2nZR43A2fWwy2K5dHLWmXU2i2iWKg9N0pclHuxJxDJrmM2lnFxwONdNjJrvsusIRZVrJJJFdPjhwTMeYXLGrBMeHaQyTEnYx4DAw+//M/HvN59F+tvmZ4PfSzoP67OYzj+8VnMfu2bRnut4LNQ/RszfPrLzXYx6JZwueyXcvuzzgzk47c+xeXXlcnQ11ptK9iPLwOfvmzJh7raRRcrbHPTHykjiD4eyCe/6j8zlAv4P3v5Sfy8HAfcIXln3yl9ePefIDCWWepMqT1HiSJk86injzLSWpuRTFnCm51IgzDZeCzZmSS61ypuFSNHOm5FLrnGm4FMOcKbnUJpfGCL15mQxrgaKGBYUiw5pgYaJIsJawqEARYa1RlLCYQBFhbZFWFwBFAWuBooUFAWtCkVC0sDBgLVE0KFpYK1g0UTQoWlgbWGyjaJCWEGARgaJG0cAaYaFAUaNoYDJKZKGoYa1g0YmigrWBxRpFibSEAYswihLWCAsJRYaFC0UNawmLKhQ1LHphMYC1RdEira4ALIIoEqwRFiKKBGuGRRJFgrWCRRNFgrWBxQaKiLS6oVDUsBawYKKoYE2wsFGUsMiFRQHWGkWDooXFBoqItLrDKFpYhFG0sODAQkLRwMJC0cAiGxZFFDUsmihqWEzBYgNFhbR6IFBUmM0uqrFddQyb1nuP6cKfNffhlD//QV9U6OGbOACA28OXpaPXbf/lXfuxc+xWUrTvgLN8kUt5udmyUIE+G4opLUbt2LYL7B4CVg/vfVatib7vtumBnj6srWtZAbUaJeOfWMknEYboRMep0zXO4cgOatJsemtGjgzHv+ueJDmtp7LmdTEpjN++LHUw8APPplSQxN5eHidDZKgI+HNSp6bweWaxuqb+VxkUg+51B+g1nvM46SvtEtWNu+k6291kWUjtgG6Q2YoJuvzdgopUDaluW7Dr3xNb7Fm1FdmJqtRn49p2Xu/gMkdMiINEzJU8SvThCYLXT7eer7Dx+0E/uUAhCrEfZvT+QxSU57gUeetuPcr+dgH7YdDF1Lkxg6z9QpksCUI/8ORrdZyvMNesmokGWe7WJuU6R5l1phdz12cgKXDnpc7JN083e1umYSn/dNgr63MYwBGFuSWkc9Gb8bnxxsAYSUn2491ys378eFgX7OsGcCGXEHXnwQuyZzP2Mcn8bxy2vA0mQzZ4EAzkkZ7/4RuTozrqRy8OX+5yU7w85LijKV2d+p9cQq2Pyd8tARwEnq1J1WFqK6ujwL3+h9N7knNhpU8bWBizkN17/YfbZ1ic/kd1"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_number-of-islands"></div></div>
</details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</details>
</div>



