# 项目记忆 - LeetCode 刷题记录

## 项目概述
- 项目路径: `/Users/data/ctl/java/idea/workspace/algorithms`
- LeetCode 题目录: `src/main/java/lchelper/leetcode/editor/cn/`
- 刷题日志: `DAILY_LOG.md`

---

## 用户刷题记录规则

### 触发时机
当用户报告完成一道题目时，按以下规则处理。

### 用户可能的输入格式
```
我今天完成了 Q15 三数之和
```
```
刷完了 Q42 接雨水
```
```
完成了 Q15、Q42、Q167
```

### 处理步骤

#### 1. 提取题目信息
- 从用户输入中提取题号和题名
- 如果用户只提供题号，从对应的 Java 文件中读取完整信息

#### 2. 读取题目文件
从 `src/main/java/lchelper/leetcode/editor/cn/Q{题号}_*.java` 读取：
- 难度等级（Easy/Medium/Hard）
- 标签信息
- 题目名称

#### 3. 更新 DAILY_LOG.md
在 `DAILY_LOG.md` 中添加今日记录：

```markdown
## {YYYY-MM-DD} {周几}

- [x] Q{题号} {题目名} [难度] - 核心思路标签
```

**示例：**
```markdown
## 2025-02-07 周五

- [x] Q15 三数之和 [Medium] - 双指针 | 排序
- [x] Q42 接雨水 [Hard] - 双指针 | 动态规划
```

#### 4. 确认回复
向用户确认记录已添加，可选择性展示：
- 今日完成数量
- 难度分布统计

---

## 已存在的题目文件（33题）

### Easy (10题)
- Q1_TwoSum - 两数之和
- Q20_ValidParentheses - 有效的括号
- Q26_RemoveDuplicatesFromSortedArray - 删除有序数组中的重复项
- Q27_RemoveElement - 移除元素
- Q83_RemoveDuplicatesFromSortedList - 删除排序链表中的重复元素
- Q206_ReverseLinkedList - 反转链表
- Q225_ImplementStackUsingQueues - 用队列实现栈
- Q232_ImplementQueueUsingStacks - 用栈实现队列
- Q283_MoveZeroes - 移动零
- Q876_MiddleOfTheLinkedList - 链表的中间结点

### Medium (22题)
- Q5_LongestPalindromicSubstring - 最长回文子串
- Q11_ContainerWithMostWater - 盛最多水的容器
- Q15_ThreeSum - 三数之和
- Q18_FourSum - 四数之和
- Q48_RotateImage - 旋转图像
- Q54_SpiralMatrix - 螺旋矩阵
- Q61_RotateList - 旋转链表
- Q71_SimplifyPath - 简化路径
- Q143_ReorderList - 重排链表
- Q151_ReverseWordsInAString - 反转字符串中的单词
- Q167_TwoSumIiInputArrayIsSorted - 两数之和 II
- Q238_ProductOfArrayExceptSelf - 除自身以外数组的乘积
- Q523_ContinuousSubarraySum - 连续的子数组和
- Q525_ContiguousArray - 连续数组
- Q560_SubarraySumEqualsK - 和为 K 的子数组
- Q622_DesignCircularQueue - 设计循环队列
- Q641_DesignCircularDeque - 设计循环双端队列
- Q921_MinimumAddToMakeParenthesesValid - 使括号有效的最少添加
- Q1094_CarPooling - 拼车
- Q1109_CorporateFlightBookings - 航班预订统计
- Q1124_LongestWellPerformingInterval - 表现良好的最长时间段
- Q1352_ProductOfTheLastKNumbers - 最后 K 个数的乘积

### Hard (1题)
- Q42_TrappingRainWater - 接雨水

---

## DAILY_LOG.md 格式规范

```markdown
# LeetCode 刷题日志

## 使用说明

### 如何记录
1. 每天完成题目后，在当日日期下添加记录
2. 格式：`- [x] Q{题号} {题目名} [难度] - 核心思路`
3. 难度标记：`[Easy]` / `[Medium]` / `[Hard]`

### 示例
```markdown
## 2024-01-15 周一

- [x] Q15 三数之和 [Medium] - 双指针
- [x] Q42 接雨水 [Hard] - 双指针/动态规划
```

---

## 日志记录

## {YYYY-MM-DD} {周几}

- [x] Q{题号} {题目名} [难度] - 核心思路
```

---

## 题目文件格式

每个题目文件顶部包含 Javadoc 注释：

```java
/**
 * Q{题号} {题目名}
 * 难度：{Easy/Medium/Hard}
 * 标签：{标签1} | {标签2} | ...
 *
 * {问题描述片段}
 */
```

---

## 注意事项

1. **不区分新完成/复习** - 每次记录都添加到当日日志
2. **日期自动获取** - 使用当前日期格式化为 `YYYY-MM-DD`
3. **标签来源** - 从题目文件的 "标签：" 行提取
4. **同一天多条记录** - 追加到同一天日期下，不重复创建日期标题
5. **文件路径** - 所有操作基于项目根目录 `/Users/data/ctl/java/idea/workspace/algorithms/`
