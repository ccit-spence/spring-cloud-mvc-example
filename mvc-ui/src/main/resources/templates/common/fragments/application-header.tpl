div(class: 'navbar navbar-default navbar-fixed-top') {
    div(class: 'container') {
        div(class: 'navbar-header') {
            a(class: 'navbar-brand', href: '/') {yield 'Spring Cloud MVC Examples'}
        }
        ul(class: 'nav navbar-nav') {
            li() {
                a(href: '/rest-template') {yield 'RestTemplate'}
            }
            li() {
                a(href: '/feign') {yield 'Feign'}
            }
        }
    }
}
