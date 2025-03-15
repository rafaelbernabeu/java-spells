package demo.jdk17.sealed.html;

public sealed interface HtmlElement permits CustomElement, Div, Paragraph, Span {

}
