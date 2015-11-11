layout 'common/layout.tpl', true,
pageTitle: title,
mainContent: contents {
    h1 'Concept'
    p 'A playground for implementing Clients within Spring Cloud. Current Services and Clients listed below.'
    ul() {
        li() yield 'Eureka - Port 8761'
        li() yield 'Hystrix Dashboard - Port 9000'
        li() yield 'Simple Rest Service - Port 8085'
        li() yield 'Simple Spring MVC Application - Port 8080'
    }
}
