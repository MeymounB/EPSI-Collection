<?php 

namespace App\Controller;

use App\Entity\Equipement;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

class AllEquipementController extends AbstractController{
	public function allequipement (){

		$allequipement = $this->getDoctrine()->getRepository(Equipement::class)->findAll();
			// dd($allequipement);
		
		return $this->render('equipement/allequipement.html.twig',[
			'allequipement' => $allequipement
			]);
 
		// return new Response($twig->render('equipement/allequipement.html.twig', [
		// 	'allequipement' => $allequipement,
		// ]));
	}
}