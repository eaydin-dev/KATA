public class Rotator {

  public Object[] rotate(Object[] data, int n) {

    // take modulo to pass unnecessary loops
    int num = n % data.length;
    
    if (n < 0)  // if we want to rotate left, we could do this by rotating it to right
      num = data.length + num;

    if (num == 0 || num % data.length == 0) // base cases
      return data;

    Object[] temp = new Object[data.length];

    for (int j = 0; j < data.length; ++j) // create a new array to store rotated array
      temp[(j+num)%data.length] = data[j];
    
    return temp;
  }

}