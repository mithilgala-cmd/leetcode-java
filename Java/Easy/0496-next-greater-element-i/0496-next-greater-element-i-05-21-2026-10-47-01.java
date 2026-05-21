class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            Stack<Integer> st = new Stack<>();
            boolean found = false;
            int ans = -1;

            for (int j = nums2.length - 1; j >= 0; j--) {
                while (!st.isEmpty() && st.peek() <= nums2[j]) {
                    st.pop();
                }

                if (nums2[j] == nums1[i]) {
                    found = true;
                    ans = st.isEmpty() ? -1 : st.peek();
                    break;
                }

                st.push(nums2[j]);
            }
            res[i] = ans;
        }
        return res;
    }
}