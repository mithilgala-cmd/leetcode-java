class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        
        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            int idx = lowerBound(products, prefix);
            List<String> suggestions = new ArrayList<>();
            
            for (int i = idx; i < products.length && suggestions.size() < 3; i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break;
                }
            }
            result.add(suggestions);
        }
        
        return result;
    }
    
    private int lowerBound(String[] products, String prefix) {
        int l = 0, r = products.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}