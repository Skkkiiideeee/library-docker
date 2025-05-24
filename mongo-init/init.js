db = db.getSiblingDB('library');

db.books.insertMany([
  {
    title: "The Red Queen",
    author: "Victoria Aveyard",
    copiesInStock: 5,
    copiesLentOut: 0
  },
  {
    title: "Folk of the Air",
    author: "Holly Black",
    copiesInStock: 2,
    copiesLentOut: 1
  }
]);
