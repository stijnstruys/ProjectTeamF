<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<section id="container">

    <header>
        <img id="header_banner" src="../img/header.png" alt="header"/>

        <div class="navbar navbar-inverse">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="/ProjectTeamF-1.0/general/index.html">Team F</a>
                    <img src="../img/Languages/<spring:message code="label.Language"/>.GIF" alt="Smiley face"
                         id="languageFlag"/>

                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li><a href="/ProjectTeamF-1.0/general/index.html"><spring:message code="label.Home"/></a>
                            </li>
                            <li><a href="/ProjectTeamF-1.0/general/about.html"><spring:message code="label.About"/></a>
                            </li>
                            <li><a href="/ProjectTeamF-1.0/trip/tripOverzicht.html"><spring:message
                                    code="label.Trip"/></a></li>
                        </ul>

                        <ul class="nav pull-right">
                            <c:if test="${empty currentUser}">
                                <li class="pull-right"><a href="/ProjectTeamF-1.0/user/user.html"><spring:message code="label.Register"/></a></li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="label.SignIn"/><b
                                            class="caret"></b></a>

                                    <ul class="dropdown-menu">
                                        <form name='f'
                                              action="<c:url value='/ProjectTeamF-1.0/j_spring_security_check' />"
                                              method='POST'>
                                            <div id="header_nav_login">
                                                <input type='text' name='j_username' class="input"
                                                       placeholder="Username">
                                                <input type='password' name='j_password' class="input"
                                                       placeholder="Password"/>

                                                <div id="header_nav_login_btn">
                                                    <input name="submit" type="submit" value="Log in" class="btn"/>
                                                    <input name="reset" type="reset" class="btn" value="Reset"/>
                                                </div>
                                            </div>
                                        </form>
                                    </ul>
                                </li>
                            </c:if>
                            <c:if test="${!empty currentUser}">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <spring:message code="label.Welcome"/> ${currentUser}<b
                                            class="caret"></b></a>

                                    <ul class="dropdown-menu">
                                        <li><a href="/ProjectTeamF-1.0/user/profile.html"><spring:message code="label.Profile"/> <i
                                                class="icon-tags pull-right"></i></a></li>
                                        <li><a href="/ProjectTeamF-1.0/user/myTrips.html"><spring:message code="label.MyTrips"/> <i
                                                class="icon-calendar pull-right"></i></a></li>
                                        <li class="divider"></li>
                                        <li><a href="/ProjectTeamF-1.0/j_spring_security_logout"><spring:message code="label.LogOut"/> <i
                                                class="icon-off pull-right"></i></a></li>
                                    </ul>
                                </li>
                            </c:if>
                        </ul>
                        <form class="navbar-search pull-right" action="../search/tripSearchResult.html" method="GET">
                            <input id="autocomplete" type="text" class="search-query span2" placeholder="<spring:message code="label.SearchTrip"/>"
                                   name="searchInput">
                        </form>


                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div id="dialog-message-languages" title="<spring:message code="label.ChooseLanguage"/>">
            <form>
                <fieldset>
                    <table id="languageTable">

                        <tr class="flagRow">
                            <td class="flagOptions">
                                <a href="?lang=nl">
                                    <img src="../img/Languages/Dutch.GIF" alt="Smiley face" class="flagsImg"/>
                                    <label class="flagLink">Nederlands</label>
                                </a>
                            </td>
                            <td class="flagOptions">
                                <a href="?lang=en">
                                    <img src="../img/Languages/English.GIF" alt="Smiley face" class="flagsImg"/>
                                    <label class="flagLink">English</label>
                                </a>
                            </td>
                        </tr>
                        <tr class="flagRow">
                            <td class="flagOptions">
                                <a href="?lang=fr">
                                    <img src="../img/Languages/French.GIF" alt="Smiley face" class="flagsImg"/>
                                    <label class="flagLink">Français</label>
                                </a>
                            </td>
                            <td class="flagOptions">
                                <a href="?lang=de">
                                    <img src="../img/Languages/German.GIF" alt="Smiley face" class="flagsImg"/>
                                    <label class="flagLink">Deutsch</label>
                                </a>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
        </div>

    </header>

