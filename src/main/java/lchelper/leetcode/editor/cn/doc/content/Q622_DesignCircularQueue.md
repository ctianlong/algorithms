<p>设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。</p>

<p>循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。</p>

<p>你的实现应该支持如下操作：</p>

<ul> 
 <li><code>MyCircularQueue(k)</code>: 构造器，设置队列长度为 k 。</li> 
 <li><code>Front</code>: 从队首获取元素。如果队列为空，返回 -1 。</li> 
 <li><code>Rear</code>: 获取队尾元素。如果队列为空，返回 -1 。</li> 
 <li><code>enQueue(value)</code>: 向循环队列插入一个元素。如果成功插入则返回真。</li> 
 <li><code>deQueue()</code>: 从循环队列中删除一个元素。如果成功删除则返回真。</li> 
 <li><code>isEmpty()</code>: 检查循环队列是否为空。</li> 
 <li><code>isFull()</code>: 检查循环队列是否已满。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
circularQueue.enQueue(1); &nbsp;// 返回 true
circularQueue.enQueue(2); &nbsp;// 返回 true
circularQueue.enQueue(3); &nbsp;// 返回 true
circularQueue.enQueue(4); &nbsp;// 返回 false，队列已满
circularQueue.Rear(); &nbsp;// 返回 3
circularQueue.isFull(); &nbsp;// 返回 true
circularQueue.deQueue(); &nbsp;// 返回 true
circularQueue.enQueue(4); &nbsp;// 返回 true
circularQueue.Rear(); &nbsp;// 返回 4</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>所有的值都在 0&nbsp;至 1000 的范围内；</li> 
 <li>操作数将在 1 至 1000 的范围内；</li> 
 <li>请不要使用内置的队列库。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>设计 | 队列 | 数组 | 链表</details><br>

<div>👍 582, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_62b43720e4b07bd2d7b1b6dd -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并「按照各个插件的解锁方法手动刷新数据」。

若之前已经购买会员并成功解锁插件，现在却突然出现这个问题，是因为添加了新的题解数据。请尝试重新手动刷新插件数据。进入 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 向下翻即可查看各个插件刷新数据的方法。

若依然无法解决问题，可以在按照 [bug 反馈页面](https://labuladong.online/algo/intro/bug-report/) 的提示像我反馈问题，如是 bug 我会立即修复。</details>
</div>

