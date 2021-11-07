//
//  ViewController.swift
//  Ecommerce
//
//  Created by SATABHISHA ROY on 05/10/21.
//

import UIKit
import NicoProgress

class SplashScreen: UIViewController {

    @IBOutlet private weak var programmaticProgressBarContainer: UIView!
    //MARK: Properties
       private var programmaticProgressBar: NicoProgressBar!
       private var state: NicoProgressBarState = .indeterminate
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        setupProgrammaticProgressBar()
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 1){ // change your delay here
              // redirect to next vc
            self.performSegue(withIdentifier: "usertype", sender: nil)
            }
    }
    private func setupProgrammaticProgressBar() {
            programmaticProgressBar = NicoProgressBar()
            programmaticProgressBar.primaryColor = .blue
//            programmaticProgressBar.secondaryColor = .red
            
            programmaticProgressBarContainer.addSubview(programmaticProgressBar)
            
            NSLayoutConstraint(item: programmaticProgressBar, attribute: .top, relatedBy: .equal, toItem: programmaticProgressBarContainer, attribute: .top, multiplier: 1.0, constant: 0).isActive = true
            NSLayoutConstraint(item: programmaticProgressBar, attribute: .bottom, relatedBy: .equal, toItem: programmaticProgressBarContainer, attribute: .bottom, multiplier: 1.0, constant: 0).isActive = true
            NSLayoutConstraint(item: programmaticProgressBar, attribute: .leading, relatedBy: .equal, toItem: programmaticProgressBarContainer, attribute: .leading, multiplier: 1.0, constant: 0).isActive = true
            NSLayoutConstraint(item: programmaticProgressBar, attribute: .trailing, relatedBy: .equal, toItem: programmaticProgressBarContainer, attribute: .trailing, multiplier: 1.0, constant: 0).isActive = true
        
        transition(to: .indeterminate)
        }

    //MARK: State
        internal func transition(to state: NicoProgressBarState) {
            self.state = state
            
            switch state {
                case .determinate(_):
//                    progressSlider.isHidden = false
//                    storyboardProgressBar.transition(to: state)
                    programmaticProgressBar.transition(to: state)
//                    indeterminateSwitchLabel.text = NSLocalizedString("Determinate", comment: "")
                case .indeterminate:
//                    progressSlider.isHidden = true
//                    storyboardProgressBar.transition(to: state)
                    programmaticProgressBar.transition(to: state)
//                    indeterminateSwitchLabel.text = NSLocalizedString("Indeterminate", comment: "")
            }
        }
}

