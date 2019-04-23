public class OutputPin extends Device {
    @Override
    protected boolean canAddInputPin() throws CannotAddInputPinException {
        if (inputPins.size() == 1)
            throw new CannotAddInputPinException();
        return true;
    }

    @Override
    public boolean compute() {
        return inputPins.get(0).compute();
    }
}
