public class GateNot extends LogicGate {

    private final String symbol;

    public GateNot(LogicVariable output, LogicVariable input) throws ColisionException, CycleException {
        super(output, input);
        this.symbol = "NOT";
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public void calculate() {
        LogicVariable input = getInputs()[0];
        setOutputValue(!input.getValue());
    }
}
