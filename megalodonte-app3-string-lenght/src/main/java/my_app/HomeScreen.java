package my_app;

import megalodonte.ComputedState;
import megalodonte.base.components.Component;
import megalodonte.base.components.ScreenComponent;
import megalodonte.base.state.State;
import megalodonte.components.Text;
import megalodonte.components.inputs.Input;
import megalodonte.components.layout_components.Container;
import megalodonte.props.ContainerProps;

public class HomeScreen implements ScreenComponent {
    State<String> textState = new State<>("");
    ComputedState<String> textLenghtComputed = ComputedState.of(
            ()-> "Size is: " + textState.get().length(), textState
    );

    @Override
    public Component render() {
       return new Container(new ContainerProps().paddingAll(20)).children(
               new Input(textState),
               new Text(textLenghtComputed)
       );
    }
}
