package exam.alibaba;

/**
 * 阿里巴巴客服管理员管理着n个客服小组，他需要为每一组安排客服24小时值班。
 * 为简单起见，假设每组只有2个客服，一天只需要1个客服上班，并且一些客服由于某些原因不能在同一天上班。

我们已经对客服进行了编号，第i（i>=1&&i<=n）个组的客服编号为2*i-1和2*i。
并且知道了m种如下约束关系：客服编号a和客服编号b不能一起上班。

管理员需要聪明的你帮忙判断今天是否存在可行的方案，既满足m条约束关系，又能让每个组都有1个客服上班。

输入：n(代表有n个组）

m(m条约束关系），接下来会有m行
a,b(代表a，b两位客服标号不能同时上班)

输出：判断有没有可行方案：如果不可行输出no；如果可行输出yes

 

举例：

输入：
4
3
1,4
2,3
7,3

输出：yes
 * @author ctl
 *
 */
public class Main3 {

}
