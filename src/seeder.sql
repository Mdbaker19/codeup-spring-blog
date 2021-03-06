create database if not exists blog_db;
use blog_db;
drop table if exists posts;
drop table if exists users;
show tables;

insert into users(email, password, username) VALUES ('matt@codeup.com', 'matthew', 'matt');

insert into posts (user_id, author, title, body, date) values (1, 'Libbi', 'middleware', 'Speak vet kibbles heel chow chow stay english mastiff greyhound heel. Speak dog shih tzu vet stand leash, puppies leave it play dead pug yorkshire terrier pomsky. Stand greyhound catch boxer bite, down growl release english mastiff release speak dog toy dog house lab.
Bite chase tail bell tennis ball dog bowl kibbles paw tug release. Leash tail vet pomsky leash rottweiler puppies, yorkshire terrier dog bone st bernard chow chow. Sit pretty puppies bring it heel collar vet chase tail sit pretty dog house.', '2013/11/5');

insert into posts (user_id, author, title, body, date) values (1, 'Adina', 'Vision-oriented', 'K9 roll over speak shih tzu dachshund sit lap dog. Rottweiler pug pomeranian pug sit pretty tug take it kibbles. Puppy vet k9 jump release chihuahua maltese boxer.
Great dance stand husky growl german shephard chihuahua great dance. Leave it sit pretty puppy bite dog toy pug english mastiff, bell tail great dance dog house. Jump bulldog tennis ball Morkie, heel poodle boxer bring it paw leap kibbles.', '2017/11/2');

insert into posts (user_id, author, title, body, date) values (1, 'Rosalyn', 'intermediate', 'Tennis ball jump rottweiler kibbles stand pug puppies milk bone dog house. Great dance puppies dog chew toy shih tzu dog toy dog bone heel. Play dead paw speak tennis ball puppy growl yorkshire terrier, down maltese take it chow chow play dead bite poodle.
Beagle boxer spin great dance speak tennis ball boxer fetch speak. Bell kibbles bring it leash squeak toy, german shephard leash speak pug tug. Husky leave it dog toy growl beagle puppy chihuahua.', '2017/1/13');

insert into posts (user_id, author, title, body, date) values (1, 'Meara', '3rd generation', '
Bell leap stay pit bull, down speak puppies pomsky rottweiler take it tail pomeranian puppy roll over. Release k9 chihuahua beagle, roll over chew toy pit bull bulldog bark bulldog maltese bark stay great dance. Chew toy doberman pinscher pit bull doberman pinscher puppies bulldog english mastiff german shephard k9, chase tail doberman pinscher roll over bite.
Poodle tennis ball pomsky boxer lap dog kibbles heel fetch. Lab poodle pomeranian st bernard Morkie pomsky, poodle doberman pinscher dachshund come poodle. Dachshund rottweiler dog bowl jump catch stand, dog bowl k9 bring it bark dog house.', '2018/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Sherye', 'support', 'Squirrel kibbles dog bowl, sit jump puppy great dance spin leap pomeranian maltese. Beagle vet greyhound shake chihuahua bring it doberman pinscher bite. Husky play dead bell roll over husky come pit bull pomsky dachshund.
Tug leash tennis ball puppy maltese stand german shephard roll over. Chew toy come leave it, stand tug dog k9 greyhound chihuahua pomeranian release rottweiler. Doberman pinscher poodle maltese, english mastiff stand bring it shih tzu german shephard chow chow lab german shephard shake.', '2010/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Abey', 'structure', 'Lap dog chase tail stand collar pomeranian kibbles, leash peanut butter bell down pomsky squeak toy st bernard take it. Sit pretty pomsky puppies chow chow pomsky bring it peanut butter chase tail, shake lab pomeranian peanut butter. Down dachshund Morkie, chew toy english mastiff pomsky dog house down puppy yorkshire terrier dog toy pomeranian pug. Squirrel puppy chihuahua chase tail puppies lap dog poodle heel. Lab lap dog bulldog, Morkie yorkshire terrier poodle down tail bulldog pit bull.', '2015/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Mellie', 'project', 'Come milk bone rottweiler, jump doberman pinscher heel puppy tug chow chow dog toy dachshund. Great dance speak pug greyhound vet puppies spin, dog bowl paw tail great dance. Peanut butter dog st bernard release rottweiler dog bone st bernard maltese. Dog bone greyhound maltese lab rottweiler bite spin german shephard kibbles. Yorkshire terrier lab pit bull play dead squeak toy squeak toy bring it german shephard chase tail.', '2016/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Brett', 'Multi-channelled', 'Dog bowl pomeranian boxer dog bowl peanut butter sit pretty k9, doberman pinscher pomeranian leave it chew toy bark. Bulldog dog house dog bowl tennis ball jump bring it great dance growl leave it, bell dog bowl tug st bernard dachshund. German shephard pit bull pomsky sit Morkie dog, lab k9 chow chow poodle. Chew toy poodle peanut butter puppy tennis ball roll over tennis ball come. Down sit pretty speak rottweiler stand husky take it play dead. Pomeranian beagle puppy pomeranian rottweiler poodle vet. Kibbles bell pomsky collar, release pomeranian play dead pomeranian chase tail maltese. Leash Morkie catch peanut butter down milk bone down great dance chase tail. German shephard collar bell yorkshire terrier german shephard yorkshire terrier leash.', '2017/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Hesther', 'object-oriented', 'Catch collar pomsky leave it dog house leave it leash stay. Chase tail lab greyhound vet poodle vet shih tzu dog house tail. Chew toy k9 leash come vet roll over down chihuahua squirrel chow chow, pug milk bone greyhound bark. Sit beagle boxer dog toy german shephard maltese rottweiler milk bone, stand growl pug poodle. Poodle stand dog house, chew toy catch jump bring it boxer catch down bring it. Squirrel bark puppy dog house collar, beagle dog chew toy great dance english mastiff Morkie pit bull dog house growl. Lap dog take it leash growl chow chow squirrel dog bone chew toy down. Dog toy spin roll over german shephard heel yorkshire terrier pug. Yorkshire terrier chow chow rottweiler paw paw rottweiler chew toy sit.', '2018/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Hyman', 'product', 'Dog toy come bark bulldog kibbles yorkshire terrier bulldog bulldog. Doberman pinscher bite stand chihuahua leave it lap dog spin dachshund play dead, pit bull lab bring it peanut butter. Bring it tail shih tzu great dance leash, tennis ball pomsky bulldog bring it chihuahua.', '2014/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Fleurette', 'implementation', 'Bell beagle maltese squeak toy puppies pit bull pug, tug bulldog pit bull speak. Poodle sit pretty dog house doberman pinscher husky tennis ball dog bone, boxer english mastiff puppies dachshund bring it. Leave it greyhound dog toy dachshund play dead, growl bite leash peanut butter squirrel squirrel bark husky. Speak squirrel come sit k9 roll over stay. Speak tennis ball come dog sit, chow chow yorkshire terrier play dead bite pomeranian shih tzu.', '2020/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Bernetta', 'Robust', 'Shih tzu vet shih tzu greyhound german shephard dog, collar shih tzu spin english mastiff. Tug bell puppy puppies, shih tzu poodle greyhound speak bulldog pomsky. Speak poodle pomeranian chase tail down leave it dog bowl tail great dance.', '2013/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Othella', 'Proactive', 'Bulldog dog chew toy play dead stand husky spin, leap heel roll over shih tzu pomsky sit pretty. Sit tail milk bone poodle, tail dog bowl chow chow Morkie puppy husky chihuahua growl shake. Great dance speak squeak toy pomeranian shake chow chow bulldog, bulldog dog toy bite catch. Lap dog tennis ball kibbles kibbles leave it catch pug. Stand pomeranian tail heel sit spin lab. Greyhound paw doberman pinscher leave it shih tzu leave it, roll over sit yorkshire terrier dachshund boxer dachshund poodle dog toy. Fetch sit pretty squirrel squirrel dog bone leave it great dance milk bone. Yorkshire terrier sit pretty squeak toy pit bull pomsky shih tzu squeak toy. Leash squeak toy greyhound come pug speak sit pretty heel vet.', '2012/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Bay', 'scalable', 'Fetch greyhound leap bring it poodle leash greyhound tennis ball catch. Bark shih tzu Morkie boxer bulldog roll over pug great dance, pit bull chew toy play dead tail bulldog. Maltese bell bite tail bark greyhound Morkie. Poodle pit bull chihuahua puppies lab pomsky leash tug. Chase tail take it stand pomeranian vet bark puppies sit pretty chow chow. Dog bowl stay doberman pinscher down poodle tennis ball dog house poodle. Rottweiler chihuahua growl german shephard st bernard husky squirrel. Paw leash catch collar rottweiler bark k9. Milk bone boxer leash roll over tug great dance lab.', '2016/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Jaime', 'content-based', 'Come stand st bernard great dance collar, bark english mastiff pomeranian sit pretty puppy. Catch dog toy puppy sit pretty, sit pretty bark vet husky squirrel poodle. Poodle husky bulldog leash boxer spin st bernard, sit pretty puppy tug chase tail collar english mastiff maltese.
English mastiff bell great dance poodle dachshund yorkshire terrier play dead dog. Lab chew toy dog house chase tail sit growl collar spin, speak chihuahua rottweiler husky chase tail rottweiler. Poodle pomeranian great dance english mastiff rottweiler bite tennis ball stay squeak toy, poodle dog house leash pit bull.', '2019/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Veronike', 'systematic', 'diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo etiam pretium iaculis justo in hac habitasse', '2012/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Gardiner', 'Enhanced', 'morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis nam congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend', '2017/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Caty', 'even-keeled', 'Stay pit bull vet heel squeak toy great dance chew toy bite. Lap dog kibbles shih tzu greyhound tail peanut butter, come heel boxer bite leave it sit. Spin growl stand Morkie bulldog lap dog chow chow bark dog house. Tail english mastiff kibbles chow chow collar take it dog bone. Bulldog shake shake bark lab catch chihuahua spin, doberman pinscher leap sit pretty chew toy bring it pomeranian.', '2013/5/14');

insert into posts (user_id, author, title, body, date) values (1, 'Ginni', 'policy', 'Leash growl leap chase tail poodle great dance, growl pomsky stand kibbles milk bone husky heel dog toy. Yorkshire terrier jump play dead shih tzu play dead speak, bring it take it beagle speak. Yorkshire terrier english mastiff squeak toy english mastiff, dachshund sit maltese bring it roll over great dance.
Doberman pinscher bell rottweiler, speak dachshund paw bring it bark bulldog down catch. St bernard jump chow chow husky collar fetch greyhound. Fetch speak growl husky shih tzu, bark english mastiff dog bone leash shake.', '2013/5/14');


select * from posts;

select * from users;
