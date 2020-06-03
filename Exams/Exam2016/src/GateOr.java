public class GateOr extends LogicGate {

    private final String symbol;

    public GateOr(LogicVariable output, LogicVariable input1, LogicVariable input2) throws ColisionException, CycleException {
        super(output, input1, input2);
        this.symbol = "OR";
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public void calculate() {
        LogicVariable[] inputs = getInputs();
        setOutputValue((inputs[0].getValue() || inputs[1].getValue()));
    }
}
