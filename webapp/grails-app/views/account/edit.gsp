<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        %{--<a href="#edit-account" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>--}%
        <div class="navbar navbar-default" role="navigation">
            <ul class="nav navbar-nav">
                <li><a class="home" href="${createLink(uri: '/')}"><span class="glyphicon glyphicon-home"></span> <g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><span class="glyphicon glyphicon-list"></span> <g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><span class="glyphicon glyphicon-plus"></span> <g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-account" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.account}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.account}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.account}" method="PUT">
                <g:hiddenField name="version" value="${this.account?.version}" />
                <fieldset class="form">
                    <f:all bean="account"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
