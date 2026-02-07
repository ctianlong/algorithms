<p>给你一份工作时间表&nbsp;<code>hours</code>，上面记录着某一位员工每天的工作小时数。</p>

<p>我们认为当员工一天中的工作小时数大于&nbsp;<code>8</code> 小时的时候，那么这一天就是「<strong>劳累的一天</strong>」。</p>

<p>所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格<strong> 大于</strong>「不劳累的天数」。</p>

<p>请你返回「表现良好时间段」的最大长度。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>hours = [9,9,6,0,6,6,9]
<strong>输出：</strong>3
<strong>解释：</strong>最长的表现良好时间段是 [9,9,6]。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>hours = [6,6,6]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= hours.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= hours[i] &lt;= 16</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 哈希表 | 前缀和 | 单调栈</details><br>

<div>👍 583, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_62b43720e4b07bd2d7b1b6dd -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并「按照各个插件的解锁方法手动刷新数据」。

若之前已经购买会员并成功解锁插件，现在却突然出现这个问题，是因为添加了新的题解数据。请尝试重新手动刷新插件数据。进入 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 向下翻即可查看各个插件刷新数据的方法。

若依然无法解决问题，可以在按照 [bug 反馈页面](https://labuladong.online/algo/intro/bug-report/) 的提示像我反馈问题，如是 bug 我会立即修复。</details>
</div>



