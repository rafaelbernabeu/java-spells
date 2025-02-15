package demo.sealed.html;

public sealed interface HtmlElement permits CustomElement, Div, Paragraph, Span {

}
