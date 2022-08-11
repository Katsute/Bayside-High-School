public class Main {
    public static void main(String[] args){
        ImaginaryNumber i1 = new ImaginaryNumber("5 + 3i");
        ImaginaryNumber i2 = new ImaginaryNumber("2 + 4i");
        System.out.println(i1.add(i2)); //Displays 7 + 7i
    }
}

public class ImaginaryNumber {
    private int real;
    private int imaginary;

    public ImaginaryNumber(String i) {
        String str = i.replace(" ","");
        int opPos;
        if(str.indexOf("+") == -1){
            opPos = str.indexOf("-");
        }else{
            opPos = str.indexOf("+");
        }
        int iPos = str.indexOf("i");
        this.real = Integer.parseInt(str.substring(0,opPos));
        this.imaginary = Integer.parseInt(str.substring(opPos,iPos));
    }

    public String add(ImaginaryNumber i2){
        ImaginaryNumber i1 = this;
        int r = i1.real + i2.real;
        int i = i1.imaginary + i2.imaginary;

        String op = "";
        if(i >= 0){
            op = "+";
        }

        return r + op + i + "i";
    }
}