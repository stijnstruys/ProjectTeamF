<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header>
            <img id="header_banner" src="./img/header.jpg" alt="header"/>
            <div class="navbar navbar-inverse">
                <div class="navbar-inner">
                    <div class="container">
                        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </a>
                        <a class="brand" href="#">Team F</a>
                        <div class="nav-collapse collapse">
                            <ul class="nav">
                                <li class="active"><a href="#">Home</a></li>
                                <li><a href="#about">About</a></li>
                            </ul>

                           <ul class="nav pull-right">
                            <li class="pull-right"><a href="#">Registreer</a></li>
                              <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Aanmelden<b class="caret"></b></a>

                                <ul class="dropdown-menu">

                                  <form id="header_login_form">
                                      <input type="text" class="input" placeholder="Email">
                                      <input type="password" class="input" placeholder="Password">
                                      <label class="checkbox">
                                        <input type="checkbox"> Aangemeld blijven
                                      </label>
                                      <button type="submit" class="btn">Aanmelden</button>
                                  </form>
                                </ul>
                              </li>
                            </ul>
                            <form class="navbar-search pull-right" action="">
                            <input type="text" class="search-query span2" placeholder="Search trip">
                          </form>
                        </div><!--/.nav-collapse -->
                    </div>
                </div>
            </div>

          </header>

