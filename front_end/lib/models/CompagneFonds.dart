import 'dart:convert';

class CompagneFonds{
  int id;
  String ref;
  String titre;
  String description;
  String dateDebut;
  String dateFin;
  String imagePath;
  int nbBeneficiaire;
  double montantObjectif;
  double montantActuel;

  CompagneFonds(
      this.id,
      this.ref,
      this.titre,
      this.description,
      this.dateDebut,
      this.dateFin,
      this.imagePath,
      this.nbBeneficiaire,
      this.montantObjectif,
      this.montantActuel);
  CompagneFonds.fromJson(Map<String, dynamic> json)
      : id = json['id'],
        ref = json['ref'],
        titre = json['titre'],
        description = json['description'],
        dateDebut = json['dateDebut'],
        dateFin = json['dateFin'],
        imagePath = json['imagePath'],
        nbBeneficiaire = json['nbBeneficiaire'],
        montantObjectif = json['montantObjectif'],
        montantActuel = json['montantActuel'];

}