class TextEditor {
    Stack<Character> left, right;

    public TextEditor() {
        left = new Stack<>();
        right = new Stack<>();
    }
    
    public void addText(String text) {
        for (char ch : text.toCharArray()) {
            left.push(ch);
        }
    }
    
    public int deleteText(int k) {
        int count = 0;
        while (!left.isEmpty() && count < k) {
            left.pop();
            count++;
        }
        return count;
    }
    
    public String cursorLeft(int k) {
        while (!left.isEmpty() && k-- > 0) {
            right.push(left.pop());
        }

        int min = Math.min(10, left.size());
        String res = "";

        Stack<Character> temp = new Stack<>();
        while (min-- > 0) {
            temp.push(left.pop());
        }

        while (!temp.isEmpty()) {
            char ch = temp.pop();
            res += ch;
            left.push(ch);
        }
        return res;
    }
    
    public String cursorRight(int k) {
        while (!right.isEmpty() && k-- > 0) {
            left.push(right.pop());
        }

        int min = Math.min(10, left.size());
        String res = "";

        Stack<Character> temp = new Stack<>();
        while (min-- > 0) {
            temp.push(left.pop());
        }

        while (!temp.isEmpty()) {
            char ch = temp.pop();
            res += ch;
            left.push(ch);
        }
        return res;
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */