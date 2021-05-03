package day23;

public class Tpl extends Instruction {

    public Tpl(char register, int argument) {
        super(Operation.TPL, register, argument);
    }
}
