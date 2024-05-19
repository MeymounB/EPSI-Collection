<?php

namespace App\Controller;

use App\Entity\Equipement;
use App\Form\EquipementFormType;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Twig\Environment; 
use Symfony\Component\HttpFoundation\Request;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\RedirectResponse;

class EquipementController extends AbstractController
{

	public function accueil(Environment $twig, Request $request, EntityManagerInterface $entityManager){
		$equipement = new Equipement();
		
		$form = $this->createForm(EquipementFormType::class, $equipement);

		$form->handleRequest($request);

		if ($form->isSubmitted() && $form->isValid()){
			$entityManager->persist($equipement);
			$entityManager->flush();

			$this->addFlash("success", "L'équipement a été ajouté !");

			return $this->redirectToRoute('equipement');
		}

		return new Response($twig->render('equipement/accueil.html.twig',[
			'equipement_form' => $form->createView()
		]));
	}
}