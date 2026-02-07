<p>设计实现双端队列。</p>

<p>实现 <code>MyCircularDeque</code> 类:</p>

<ul> 
 <li><code>MyCircularDeque(int k)</code>&nbsp;：构造函数,双端队列最大为 <code>k</code> 。</li> 
 <li><code>boolean insertFront()</code>：将一个元素添加到双端队列头部。 如果操作成功返回 <code>true</code>&nbsp;，否则返回 <code>false</code> 。</li> 
 <li><code>boolean insertLast()</code>&nbsp;：将一个元素添加到双端队列尾部。如果操作成功返回 <code>true</code>&nbsp;，否则返回 <code>false</code> 。</li> 
 <li><code>boolean deleteFront()</code>&nbsp;：从双端队列头部删除一个元素。 如果操作成功返回 <code>true</code>&nbsp;，否则返回 <code>false</code> 。</li> 
 <li><code>boolean deleteLast()</code>&nbsp;：从双端队列尾部删除一个元素。如果操作成功返回 <code>true</code>&nbsp;，否则返回 <code>false</code> 。</li> 
 <li><code>int getFront()</code>&nbsp;)：从双端队列头部获得一个元素。如果双端队列为空，返回 <code>-1</code>&nbsp;。</li> 
 <li><code>int getRear()</code>&nbsp;：获得双端队列的最后一个元素。&nbsp;如果双端队列为空，返回 <code>-1</code> 。</li> 
 <li><code>boolean isEmpty()</code>&nbsp;：若双端队列为空，则返回&nbsp;<code>true</code>&nbsp;，否则返回 <code>false</code> &nbsp;。</li> 
 <li><code>boolean isFull()</code>&nbsp;：若双端队列满了，则返回&nbsp;<code>true</code>&nbsp;，否则返回 <code>false</code> 。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入</strong>
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
<strong>输出</strong>
[null, true, true, true, false, 2, true, true, true, 4]

<strong>解释</strong>
MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
circularDeque.insertLast(1);			        // 返回 true
circularDeque.insertLast(2);			        // 返回 true
circularDeque.insertFront(3);			        // 返回 true
circularDeque.insertFront(4);			        // 已经满了，返回 false
circularDeque.getRear();  				// 返回 2
circularDeque.isFull();				        // 返回 true
circularDeque.deleteLast();			        // 返回 true
circularDeque.insertFront(4);			        // 返回 true
circularDeque.getFront();				// 返回 4
&nbsp;</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= 1000</code></li> 
 <li><code>0 &lt;= value &lt;= 1000</code></li> 
 <li><code>insertFront</code>,&nbsp;<code>insertLast</code>,&nbsp;<code>deleteFront</code>,&nbsp;<code>deleteLast</code>,&nbsp;<code>getFront</code>,&nbsp;<code>getRear</code>,&nbsp;<code>isEmpty</code>,&nbsp;<code>isFull</code>&nbsp; 调用次数不大于&nbsp;<code>2000</code>&nbsp;次</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>设计 | 队列 | 数组 | 链表</details><br>

<div>👍 256, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_62b43720e4b07bd2d7b1b6dd -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并「按照各个插件的解锁方法手动刷新数据」。

若之前已经购买会员并成功解锁插件，现在却突然出现这个问题，是因为添加了新的题解数据。请尝试重新手动刷新插件数据。进入 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 向下翻即可查看各个插件刷新数据的方法。

若依然无法解决问题，可以在按照 [bug 反馈页面](https://labuladong.online/algo/intro/bug-report/) 的提示像我反馈问题，如是 bug 我会立即修复。</details>
</div>

