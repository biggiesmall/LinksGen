 
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
                               <select autofocus="autofocus" tabindex="1" id="title" name="title" class="uiStyle" onFocus="showHideTip(this);">
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

                       <li class="field-container"><label for="firstname">
                               <span class="field-name">Nom</span>
                               <input type="text" tabindex="1" value="" id="firstname" name="firstname" class="uiStyle" onFocus="showHideTip(this);"></label>
                           <div id="firstnameTip" class="hidden formTip">
                               Votre nom
                           </div>
                       </li>

                       <li class="field-container"><label for="lastname">
                               <span class="field-name">Prénom</span>
                               <input type="text" tabindex="1" value="" id="lastname" name="lastname" class="uiStyle" onFocus="showHideTip(this);"></label>
                           <div id="lastnameTip" class="hidden formTip">
                               Votre pr&eacute;nom
                           </div>
                       </li>

                       <li class="field-container"><label for="emailAddress">
                               <span class="field-name">Adresse e-mail</span>
                               <input type="text" tabindex="1" value="" id="emailAddress" name="emailAddress" class="uiStyle" onFocus="showHideTip(this);"></label>
                           <div id="emailAddressTip" class="hidden formTip">
                               V&eacute;rifiez votre messagerie. Vous allez recevoir un mail de confirmation.
                           </div>
                       </li>

                       <li class="field-container"><label for="emailAddressConfirm">
                               <span class="field-name">Confirmation mail</span>
                               <input type="text" tabindex="2" value="" id="emailAddressConfirm" name="emailAddressConfirm" class="uiStyle" onFocus="showHideTip(this);"></label>
                           <div id="emailAddressConfirmTip" class="hidden formTip">
                               Merci de confirmer votre mail.
                           </div>
                       </li>

                       <li class="field-container"><label for="username">
                               <span class="field-name">Nom d'utilisateur</span>
                               <input type="text" tabindex="3" value="" id="username" name="username" class="uiStyle" onFocus="showHideTip(this);"></label>
                           <div id="usernameTip" class="hidden formTip">
                               Votre pseudo. 6 &agrave; 20 caract&egrave;res alpha-num&eacute;riques.
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