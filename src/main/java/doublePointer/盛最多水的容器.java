package doublePointer;

/**
 * @description: https://mp.weixin.qq.com/s?__biz=MzI2NjI5MzU2Nw==&mid=2247484306&idx=1&sn=58469e3b2be83d239e24c604f9f16990&chksm=ea911bc2dde692d4b37184b8fc3e4a64c782b009fa0aa10c8e2c6d01607b42658b7e273cd673&scene=126&sessionid=1583656901&key=b5fc890b503623ed1c7a4d159f5893ccdc607d620f12dc25faa2d66e732ea506f318d1348c20771815b5ff70e3e5fcad2388f98e867bb7281a1aeeea93bfa15cc3b3b6049f8af2149b480f29f0373029&ascene=1&uin=MjE2Mjc3OTYyNg%3D%3D&devicetype=Windows+10&version=6208006f&lang=zh_CN&exportkey=AydcIJs5pG7BTIKI1MpWAvw%3D&pass_ticket=YK8M%2BvuU%2FU9YUteVP1Jys48omG7gwrzXaDFusp6lJpnntdy%2F%2FX5F4%2FRPyrEaxYcm
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 中等
 * tag: 数组、双指针
 * @author: Kevin
 * @createDate: 2020/3/8
 * @version: 1.0
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        盛最多水的容器 solution = new 盛最多水的容器();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = solution.maxArea(height);
        System.out.println(res); // 49
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = height[l] < height[r] ? // 短板原理。 以短板计算所能盛的水
                    Math.max(res, (r - l) * height[l++]) :
                    Math.max(res, (r - l) * height[r--]);
        }
        return res;
    }
}
