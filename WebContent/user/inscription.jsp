
   <!-- register form -->
   <div class="pageSectionMain ui-corner-all">
       <div class="pageSectionMainInternal">
           <div id="pageHeader">
               <h2>Créer un compte</h2>
           </div>
           <div>
               <p class="introText">
                   Merci de renseigner le formulaire ci-dessous pour cr&eacute;er votre compte. Les d&eacute;tails de votre compte vous seront ensuite envoy&eacute;s par e-mail.
               </p>
               <form class="international" method="post" action="Inscription" id="form-join">
                   <ul>
                       <li class="field-container">
                           <label for="title">
                               <span class="field-name">Titre</span>
                               <select autofocus="autofocus" tabindex="1" id="title" name="user.civilite" class="uiStyle" onFocus="showHideTip(this);">
                                   <option value="Mr">Mr</option>
                                   <option value="Mrs">Mme</option>
                                   <option value="Miss">Mlle</option>
                                   <option value="Pro">Pro</option>
                               </select>
                           </label>
                           <div id="titleTip" class="hidden formTip">
                               Votre statut
                           </div>
                       </li>

<jsp:useBean id="user" class="linksGen.beans.User" scope="request" />
                       <li class="field-container"><label for="firstname">
                               <span class="field-name">Nom</span>
                               <input type="text" value='<jsp:getProperty property="nom" name="user"/>' tabindex="1" value="" id="firstname" name="user.nom" class="uiStyle" onFocus="showHideTip(this);"></label>
                           <div id="firstnameTip" class="hidden formTip">
                               Votre nom
                           </div>
                       </li>

                       <li class="field-container"><label for="lastname">
                               <span class="field-name">Prénom</span>
                               <input type="text" tabindex="1" value="" id="lastname" name="user.prenom" class="uiStyle" onFocus="showHideTip(this);"></label>
                           <div id="lastnameTip" class="hidden formTip">
                               Votre pr&eacute;nom
                           </div>
                       </li>

                       <li class="field-container"><label for="emailAddress">
                               <span class="field-name">Adresse e-mail</span>
                               <input type="text" tabindex="1" value="" id="emailAddress" name="user.email" class="uiStyle" onFocus="showHideTip(this);"></label>
                           <div id="emailAddressTip" class="hidden formTip">
                               V&eacute;rifiez votre messagerie. Vous allez recevoir un mail de confirmation.
                           </div>
                       </li>

                       <li class="field-container"><label for="emailAddressConfirm">
                               <span class="field-name">Password</span>
                               <input type="password" tabindex="2" value="" id="emailAddressConfirm" name="user.password" class="uiStyle" onFocus="showHideTip(this);"></label>
                           <div id="emailAddressConfirmTip" class="hidden formTip">
                               Merci de confirmer votre mail.
                           </div>
                       </li>

                       <li class="field-container">
                           <span class="field-name"></span>
                           <input tabindex="99" type="submit" name="submit" value="Enregistrement" class="submitInput" />
                       </li>
                   </ul>

                   <input type="hidden" value="1" name="submitme"/>
               </form>

               <div class="disclaimer">
                   En cliquant sur 'Enregistrement', vous acceptez nos <a href="#" onClick="showTerms(); return false;">conditions d'utilisation</a>.
               </div>
               <div class="clear"></div>
           </div>
       </div>
   </div>