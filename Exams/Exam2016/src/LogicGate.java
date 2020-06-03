import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class LogicGate {

    private LogicVariable output;
    private LogicVariable[] inputs;

    public LogicGate(LogicVariable output, LogicVariable input1, LogicVariable input2) throws ColisionException, CycleException {

        if(output.getCalculatedBy() != null) throw new ColisionException();

        if(input1.getCalculatedBy() != null)
            if(input1.getCalculatedBy().inputsContains(output))
                throw new CycleException();

        if(input2.getCalculatedBy() != null)
            if(input2.getCalculatedBy().inputsContains(output))
                throw new CycleException();

        this.output = output;
        this.output.setCalculatedBy(this);
        this.inputs = new LogicVariable[]{input1, input2};

    }

    public LogicGate(LogicVariable output, LogicVariable input) throws ColisionException, CycleException {

        if(output.getCalculatedBy() != null) throw new ColisionException();

        if(input.getCalculatedBy() != null)
            if(input.getCalculatedBy().inputsContains(output))
                throw new CycleException();

        this.output = output;
        this.output.setCalculatedBy(this);
        this.inputs = new LogicVariable[]{input};

    }

    public LogicVariable getOutput() {
        return output;
    }

    public LogicVariable[] getInputs() {
        return inputs;
    }

    public abstract String getSymbol();
    public abstract void calculate();

    public String getFormula() {
        return output.getFormula();
    }

    public void setOutputValue(boolean value) {
        this.output.setValue(value);
    }

    private boolean inputsContains(LogicVariable variable){
        for(LogicVariable v : inputs){
            if(v.equals(variable)) return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogicGate)) return false;
        LogicGate logicGate = (LogicGate) o;
        return Objects.equals(output, logicGate.output) &&
                Arrays.equals(inputs, logicGate.inputs);
    }

}
