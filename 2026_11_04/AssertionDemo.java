public class AssertionDemo {
public static void main(String[] args) {
int i; int sum = 0;
for (i = 0; i < 10; i++) {
sum += i;
}
// assert i == 21 : "i is not equal to 21";
assert sum > 1000 && sum < 5 * 1000 : "sum is " + sum;
}
}

