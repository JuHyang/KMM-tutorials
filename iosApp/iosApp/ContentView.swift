import SwiftUI
import shared

struct ContentView: View {
  @ObservedObject private(set) var viewModel: ViewModel
  
  var body: some View {
    ListView(phrases: viewModel.greetings)
      .onAppear { self.viewModel.startObserving() }
  }
}

extension ContentView {
    @MainActor
    class ViewModel: ObservableObject {
        @Published var greetings: Array<String> = []

        func startObserving() {
            // ...
          print ("##ARTHUR Greeeting \(Greeting().greet())")
          Greeting().greet().collect(collector: Collector<String> { value in
            self.greetings.append(value)
          }) { error in
          }
        }
    }
}

struct ListView: View {
    let phrases: Array<String>

    var body: some View {
        List(phrases, id: \.self) {
            Text($0)
        }
    }
}
