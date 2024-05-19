<?php

namespace App\Controller;

use App\Entity\Equipement;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Routing\Annotation\Route;

class DescriptionController extends AbstractController{

	/**
	 *@Route("/equipement/description/{id}", name="description_show")
	*/
	public function show($id){
		$repo = $this->getDoctrine()->getRepository(Equipement::class);
		$description = $repo->find($id);
		return $this->render('equipement/description.html.twig',[
		'description' =>$description
		]);
	}
}