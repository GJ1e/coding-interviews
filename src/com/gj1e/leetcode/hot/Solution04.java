package com.gj1e.leetcode.hot;

/**
 * @author FenDa
 * 4. 寻找两个正序数组的中位数
 */
public class Solution04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ways1(nums1, nums2);
        ways2(nums1, nums2);
        ways3(nums1, nums2);
        return 0.0;
    }

    /**
     * 解法1 合并两个有序数组，根据数组长度返回数组中位数。时间复杂度O(M+N)，空间复杂度O(M+N)
     * @param nums1
     * @param nums2
     * @return
     */
    public double ways1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        int[] res = new int[n1 + n2];

        if (n1 == 0) {
            if (n2 % 2 == 0) {
                return (nums2[n2 / 2 - 1] + nums2[n2 / 2]) / 2.0;
            } else {
                return nums2[n2 / 2];
            }
        }
        if (n2 == 0) {
            if (n1 % 2 == 0) {
                return (nums1[n1 / 2 - 1] + nums1[n1 / 2]) / 2.0;
            } else {
                return nums1[n1 / 2];
            }
        }
        int count = 0;
        while (count < (n1 + n2)) {
            if (i == n1) {
                while (j < n2) {
                    res[count++] = nums2[j++];
                }
                break;
            }
            if (j == n2) {
                while (i < n1) {
                    res[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] <= nums2[j]) {
                res[count++] = nums1[i++];
            } else {
                res[count++] = nums2[j++];
            }
        }
        if (count % 2 == 0) {
            return (res[count / 2 - 1] + res[count / 2]) / 2.0;
        } else {
            return res[count / 2];
        }
    }

    /**
     * 解法2 对解法1进行优化，不用真正合并两个数组，用下表记录寻找中位数。时间复杂度O(M+N),空间复杂度O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public double ways2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int sumLen = n1 + n2;
        int aStart = 0, bStart = 0;
        int pre = -1, post = -1;
        for (int i = 0; i < sumLen / 2 + 1; i++) {
            pre = post;
            if (aStart < n1 && (bStart >= n2 || nums1[aStart] < nums2[bStart])) {
                post = nums1[aStart++];
            } else {
                post = nums2[bStart++];
            }
        }
        if (sumLen % 2 == 0) {
            return (post + pre) / 2.0;
        } else {
            return post;
        }
    }

    /**
     * 解法三 用二分查找的思想，将查找中位数转换成查找第K小的数，时间复杂度O(log(M+N)),空间复杂度O(1)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int ways3(int[] nums1, int[] nums2) {
        int left = (nums1.length + nums2.length + 1) / 2;
        int right = (nums1.length + nums2.length + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right))/2;
    }
    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int n1Mid = (i + k / 2 - 1 >= nums1.length) ? Integer.MAX_VALUE : nums1[i + k / 2 - 1];
        int n2Mid = (j + k / 2 - 1 >= nums2.length) ? Integer.MAX_VALUE : nums2[j + k / 2 - 1];
        if (n1Mid > n2Mid) {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        } else {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        }
    }


}
