<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        %{--<a href="#list-account" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>--}%
        <div class="navbar navbar-default" role="navigation">
            <ul class="nav navbar-nav">
                <li><a class="home" href="${createLink(uri: '/')}"><span class="glyphicon glyphicon-home"></span> <g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><span class="glyphicon glyphicon-plus"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-account" class="content scaffold-list" role="main">
            <h4><g:message code="default.list.label" args="[entityName]" /></h4>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="table-responsive">
                <f:table collection="${accountList}" />
            </div>

            <div class="pagination">
                <g:paginate total="${accountCount ?: 0}" />
            </div>
        </div>
    </body>
</html>