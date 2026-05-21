class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String operation : operations) {
            if(operation.equals("+")) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a + b);
            }
            else if(operation.equals("D")) {stack.push(2 * stack.peek());}
            else if(operation.equals("C")) {stack.pop();}
            else {stack.push(Integer.parseInt(operation));}
        }

        int sum = 0;    
        for(int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }
        return sum;
    }
}