#!/usr/bin/perl
use strict;
use warnings;

my $path="nameToFind.txt";
my $in="";

my $inserted=0;

open my $file, "<", $path or die "Can't open $path: $!";

while (my $line = <$file>)
{
	for($line =~ /^Fabien Delorme/) {
		chomp($line);
		(my $auteur, my $coauteur) = split /:/, $line, 2;
		$in = $in . $coauteur;
	}
}
close $file;

my @results = split /,/, $in;
my $nb_co_auteur = 0;
my $result = "";

for my $res (@results) {
	unless($result =~ /\Q$res/) {
		$nb_co_auteur++;
		$result = $result . $res . "\n";
	}
}

print("Fabien Delorme has " . $nb_co_auteur . " co-athors\n");
print($result);


