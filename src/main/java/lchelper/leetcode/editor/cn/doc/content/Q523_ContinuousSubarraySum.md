<p>给你一个整数数组 <code>nums</code> 和一个整数&nbsp;<code>k</code> ，如果&nbsp;<code>nums</code>&nbsp;有一个 <strong>好的子数组</strong>&nbsp;返回&nbsp;<code>true</code>&nbsp;，否则返回 <code>false</code>：</p>

<p>一个&nbsp;<strong>好的子数组</strong>&nbsp;是：</p>

<ul> 
 <li>长度&nbsp;<strong>至少为 2</strong> ，且</li> 
 <li>子数组元素总和为 <code>k</code> 的倍数。</li> 
</ul>

<p><strong>注意</strong>：</p>

<ul> 
 <li><strong>子数组</strong> 是数组中 <strong>连续</strong> 的部分。</li> 
 <li>如果存在一个整数 <code>n</code> ，令整数 <code>x</code> 符合 <code>x = n * k</code> ，则称 <code>x</code> 是 <code>k</code> 的一个倍数。<code>0</code> <strong>始终</strong> 视为 <code>k</code> 的一个倍数。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [23<u>,2,4</u>,6,7], k = 6
<strong>输出：</strong>true
<strong>解释：</strong>[2,4] 是一个大小为 2 的子数组，并且和为 6 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [<u>23,2,6,4,7</u>], k = 6
<strong>输出：</strong>true
<strong>解释：</strong>[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [23,2,6,4,7], k = 13
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>0 &lt;= sum(nums[i]) &lt;= 2<sup>31</sup> - 1</code></li> 
 <li><code>1 &lt;= k &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 数学 | 前缀和</details><br>

<div>👍 641, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_62b43720e4b07bd2d7b1b6dd -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并「按照各个插件的解锁方法手动刷新数据」。

若之前已经购买会员并成功解锁插件，现在却突然出现这个问题，是因为添加了新的题解数据。请尝试重新手动刷新插件数据。进入 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 向下翻即可查看各个插件刷新数据的方法。

若依然无法解决问题，可以在按照 [bug 反馈页面](https://labuladong.online/algo/intro/bug-report/) 的提示像我反馈问题，如是 bug 我会立即修复。</details>
</div>

