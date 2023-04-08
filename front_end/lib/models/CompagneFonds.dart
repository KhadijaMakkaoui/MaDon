class CompagneFonds{
  int id;
  String nom;
  String description;
  String dateDebut;
  String dateFin;
  String image;
  String type;
  String etat;

  CompagneFonds(this.id, this.nom, this.description, this.dateDebut,
      this.dateFin, this.image, this.type, this.etat);
  static CompagneFonds fromJson(Map<String, dynamic> json) {
    return CompagneFonds(
      json['id'],
      json['nom'],
      json['description'],
      json['dateDebut'],
      json['dateFin'],
      json['image'],
      json['type'],
      json['etat'],
    );
  }
}