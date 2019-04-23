public class InputPin extends Device {
    private boolean value;

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    protected boolean canAddInputPin() throws CannotAddInputPinException {
        if (inputPins.size() == 1)
            throw new CannotAddInputPinException();
        return true;
    }

    @Override
    public boolean compute() {
        return value;
    }
}
