/*
import 'package:intl/intl.dart';
*/

class Dons {
  /*int id;
  String ref;*/
  double montant;
  /*String date;*/

  Dons({required this.montant});

  factory Dons.fromJson(Map<String, dynamic> json) => Dons(
    montant: json['montant'],
  );

  Map<String, dynamic> toJson() => {
   /* 'id': id,
    'ref': ref,*/
    'amount': montant,
    /*'date': date,*/
  };

/*  static final DateFormat _dateFormat = DateFormat('yyyy-MM-dd');

  static String formatDate(DateTime dateTime) {
    return _dateFormat.format(dateTime);
  }*/
}
