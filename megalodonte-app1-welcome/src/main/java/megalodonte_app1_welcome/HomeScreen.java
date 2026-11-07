package megalodonte_app1_welcome;

import megalodonte.base.components.Component;
import megalodonte.base.components.ScreenComponent;
import megalodonte.components.Text;
import megalodonte.components.layout_components.Container;
import megalodonte.props.ContainerProps;
import megalodonte.props.TextProps;

public class HomeScreen implements ScreenComponent {

    @Override
    public Component render() {
        return new Container(new ContainerProps().paddingAll(20)).children(
                new Text("Hello World", new TextProps().fontSize(50))
        );
    }
}
