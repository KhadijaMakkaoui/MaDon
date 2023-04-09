import 'package:flutter/material.dart';
import 'package:front_end/models/CompagneFonds.dart';
import 'package:front_end/services/CompagneService.dart';

import '../constants/colors.dart';
import 'Details.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  late Future<List<CompagneFonds>> futureCompagneFonds;

  @override
  void initState() {
    super.initState();
    futureCompagneFonds= CompagneService().get('');
  }
/*
  Future<List<CompagneFonds>> _getCompagneFonds() async {
    var response = await CompagneService().get('');
    debugPrint('success');

    // parse the response into a list of Compagnes objects
    List<CompagneFonds> compagneFonds =
    (response as List).map((compagne) => CompagneFonds.fromJson(compagne)).toList();

    return compagneFonds;
  }
*/


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: SingleChildScrollView(
        child: Container(
            margin: EdgeInsets.only(top: 50),
            padding: EdgeInsets.symmetric(horizontal: 20),
            child: Column(children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    'MADON',
                    style: TextStyle(
                      fontSize: 30,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  Text(
                    'Home',
                    style: TextStyle(
                      color: Colors.grey,
                      fontSize: 20,
                    ),
                  ),
                  IconButton(
                      onPressed: () {},
                      icon: Icon(
                        Icons.notifications_none_outlined,
                        color: Colors.grey,
                        size: 30,
                      )),
                ],
              ),
              SizedBox(
                height: 20,
              ),
              Row(
                children: [
                  Expanded(
                    child: TextField(
                      decoration: InputDecoration(
                        prefixIcon: Icon(Icons.search),
                        hintText: 'Search...',
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(10),
                        ),
                      ),
                    ),
                  ),
                ],
              ),
              SizedBox(
                height: 20,
              ),
              Row(
                children: [
                  Container(
                    decoration: BoxDecoration(
                      color: kBackground,
                      borderRadius: BorderRadius.circular(10),
                    ),
                    padding: EdgeInsets.symmetric(vertical: 10,horizontal:15),
                    //QUOTE
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Text(
                          '"Happiness doesn’t result from what we get,but\nfrom what we give"',
                          style: TextStyle(
                            color: Colors.black87,
                            fontSize: 15,
                            fontStyle: FontStyle.italic,
                          ),
                        ),
                        SizedBox(height: 8),
                        Text(
                          '- Ben Carson',
                          style: TextStyle(
                            color: Colors.black87,
                            fontSize: 16,
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
              SizedBox(
                height: 20,
              ),
              Container(
                height: 100,
                margin: const EdgeInsets.symmetric(vertical: 10),
                child: ListView(
                  scrollDirection: Axis.horizontal,
                  children: [
                    _buildCategoryCard(context, 'Medical', 'medical.png'),
                    _buildCategoryCard(context, 'Education', 'education.png'),
                    _buildCategoryCard(context, 'Food', 'food.png'),
                    _buildCategoryCard(context, 'Housing', 'housing.png'),
                  ],
                ),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text(
                    'Fundraisings Campaigns',
                    style: TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                 /* GestureDetector(
                    onTap: () {
*//*
                      Navigator.push(context, MaterialPageRoute(builder: (context) =>  Menu()));
*//*
                    },
                    child: Text(
                      'View More',
                      style: TextStyle(
                        fontSize: 16,
                        fontWeight: FontWeight.bold,
                        color: Colors.blue,
                      ),
                    ),
                  ),*/
                ],
              ),
              SizedBox(height: 20,),
              Container(
                height: 450,
                child: FutureBuilder<List<CompagneFonds>>(
                    future: futureCompagneFonds,
                    builder: (context, snapshot) {
                      if (snapshot.hasData) {
                        List<CompagneFonds> comps = snapshot.data!;

                        return ListView.separated(
                          itemCount: comps.length,
                          separatorBuilder: (BuildContext context, int index) =>
                              SizedBox(height: 16),
                          itemBuilder: (BuildContext context, int index) {
                            CompagneFonds comp = comps[index];

                            return GestureDetector(
                              onTap: () {
                                /*Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                    builder: (context) =>
                                        Menu(restaurantRef: resto),
                                  ),
                                );*/
                              },
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.stretch,
                                children: [
                                  // restaurant details
                                  buildCompagne(comp),
                                ],
                              ),
                            );
                          },
                        );
                      } else if (snapshot.hasError) {
                        return Text('Error ${snapshot.error}');
                      } else {
                        return const Center(child: CircularProgressIndicator());
                      }
                    }),
              ),
            ]
            ),
        ),


      ),
    );
  }

  Widget _buildCategoryCard(
      BuildContext context, String title, String imagePath) {
    return Container(
      width: 100,
      margin: const EdgeInsets.symmetric(horizontal: 6),
      child: GestureDetector(
        onTap: () {
          /* Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => Menu(),
            ),
          );*/
        },
        child: Card(
          elevation: 0,
          child: Column(
            children: [
              Image.asset(
                imagePath,
                height: 50,
                /*width: double.infinity,*/
                fit: BoxFit.cover,
              ),
              SizedBox(height: 5),
              Text(
                title,
                style: TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
  Widget buildCompagne(CompagneFonds compagne) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Padding(
          padding: const EdgeInsets.all(0),
          child: ClipRRect(
            borderRadius: BorderRadius.circular(10.0),
            child: Image.asset(
              /*compagne.imagePath*/
              'assets/iftar.jpg',
              height: 200,
              width: double.infinity,
              fit: BoxFit.cover,
            ),
          ),
        ),
        SizedBox(height: 10),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  compagne.titre,
                  style: const TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                const SizedBox(
                  height: 10,
                ),
                Text(
                  'Number of beneficiaries:${compagne.nbBeneficiaire} people',
                  style: const TextStyle(
                    fontSize: 14,
                    color: Colors.grey,
                  ),
                ),
                const SizedBox(
                  height: 8,
                ),
                Text(
                  'Amount to collect: ${compagne.montantObjectif} DH',
                  style: const TextStyle(
                    fontSize: 15,
                    color: Colors.lightGreen,
                  ),
                ),
                const SizedBox(
                  width: 10,
                ),
                const SizedBox(
                  width: 15,
                ),
              ],
            ),
            Column(
              children: [
                ElevatedButton(
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => Details(campaignId: compagne.id,)),
                    );
                  },
                  style: ElevatedButton.styleFrom(
                    foregroundColor: Colors.white,
                    backgroundColor: kPrimaryColor,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10.0),
                    ),
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text(
                        'Details',
                        style: TextStyle(fontSize: 18),
                      ),
                      SizedBox(width: 8),
                      Icon(Icons.arrow_forward_ios, size: 20),
                    ],
                  ),
                ),

              ],
            )
          ],
        ),
        SizedBox(height: 20),
      ],
    );
  }
}

