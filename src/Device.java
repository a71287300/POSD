import java.util.ArrayList;
import java.util.List;

public abstract class Device {
    protected List<Device> inputPins = new ArrayList<>();

    public abstract boolean compute();

    protected boolean canAddInputPin() throws CannotAddInputPinException {
        return true;
    }

    public void addInputPin(Device inputPin) {
        try {
            if (this.canAddInputPin()) {
                inputPins.add(inputPin);
            }
        } catch (CannotAddInputPinException e) {
            e.getMessage();
        }
    }
}
