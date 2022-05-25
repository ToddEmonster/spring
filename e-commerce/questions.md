# Conclusion suite aux TPs Spring

## TODO

- [ ] Ajouter méthode addNewRegisteredUser dans Service
- [ ] Créer un mapper
- [ ] Custom 404 
- [ ] Custom 403
- [ ] Schéma draw.io de l'application e-commerce


## DONE
- [x] Vérifier class ContactDTO

## Questions

- Dans un Controller, pourquoi `@GetMapping / 
  @PostMapping`, plutôt  que `@RequestMapping(options...)
  ` ? => 
- Dans un Controller, pourquoi a-t-on besoin que les 
  méthodes mappées sur des routes soient 


## Réponses / A retenir

* Dépendance `spring-security-taglibs` nécessaire 
* Possibilité de découper et appeler les bouts de page 
HTML sous format JSP, comme en PHP 
* Attribut "name" sur les inputs est NECESSAIRE pour le 
  mapping 
* FetchType EAGER vs LAZY 
* WebSecurityConfig.config au niveau des protections des 
  routes : ordre de chaînage est important (`anyRequest().
  authenticated()` ne doit être utilisé qu'une unique fois)
* `@RestController` = avec librairie Jackson, attend un 
  String dans les méthodes liées à des routes afin de 
  désérialiser en JSON. `@Controller` est ici (dans 
  `application.properties`) configuré pour aller 
  chercher des fichiers JSP, la sortie en String est 
  le nom du fichier