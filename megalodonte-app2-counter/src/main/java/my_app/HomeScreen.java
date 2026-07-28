package my_app;

import megalodonte.base.components.Component;
import megalodonte.base.components.ScreenComponent;
import megalodonte.base.state.State;
import megalodonte.components.Button;
import megalodonte.components.SpacerVertical;
import megalodonte.components.Text;
import megalodonte.components.layout_components.Container;
import megalodonte.props.ButtonProps;
import megalodonte.props.ContainerProps;
import megalodonte.props.TextProps;

public class HomeScreen implements ScreenComponent {
    State<Integer> counter = new State<>(0);

    @Override
    public Component render() {

        ButtonProps btnProps = new ButtonProps().fontSize(30);

        return new Container(new ContainerProps().paddingAll(20)).children(
                new Text(counter.map(Object::toString), new TextProps().fontSize(90)),
                new Button("Decrement", btnProps).onClick(()-> counter.set(counter.get() - 1)),
                new SpacerVertical(10),
                new Button("Increment", btnProps).onClick(()-> counter.set(counter.get() + 1))
        );
    }
}
